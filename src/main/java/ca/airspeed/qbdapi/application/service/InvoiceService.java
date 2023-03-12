package ca.airspeed.qbdapi.application.service;

import ca.airspeed.qbdapi.application.port.in.GenerateInvoicesUseCase;
import ca.airspeed.qbdapi.application.port.in.RetrieveInvoiceUseCase;
import ca.airspeed.qbdapi.application.port.in.SearchForInvoiceUseCase;
import ca.airspeed.qbdapi.application.port.out.InvoicePort;
import ca.airspeed.qbdapi.application.port.out.RetrieveCustomerPort;
import ca.airspeed.qbdapi.application.port.out.ServiceItemPort;
import ca.airspeed.qbdapi.application.port.out.TimesheetPort;
import ca.airspeed.qbdapi.domain.Customer;
import ca.airspeed.qbdapi.domain.Invoice;
import ca.airspeed.qbdapi.domain.InvoiceLineDetail;
import ca.airspeed.qbdapi.domain.Item;
import ca.airspeed.qbdapi.domain.ServiceItem;
import ca.airspeed.qbdapi.domain.TimesheetEntry;
import lombok.RequiredArgsConstructor;

import jakarta.inject.Singleton;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Singleton
@RequiredArgsConstructor
public class InvoiceService implements RetrieveInvoiceUseCase, SearchForInvoiceUseCase, GenerateInvoicesUseCase {

    private final InvoicePort invoicePort;
    private final TimesheetPort timesheetPort;
    private final RetrieveCustomerPort retrieveCustomerPort;
    private final ServiceItemPort serviceItemPort;

    private final Map<String, Customer> jobCustomerMap = new HashMap<>();

    @Override
    public List<Invoice> findByInvoiceNumber(String invoiceNumber) {
        return invoicePort.findByInvoiceNumber(invoiceNumber);
    }

    @Override
    public Invoice retrieveInvoice(String id) {
        return invoicePort.findById(id);
    }

    @Override
    public List<Invoice> generateTimeAndMaterialsInvoices() {
        LocalDate startOfLastMonth = LocalDate.now().minusMonths(1).withDayOfMonth(1);
        LocalDate endOfLastMonth = startOfLastMonth.plusMonths(1).minusDays(1);
        List<TimesheetEntry> timesheets = timesheetPort.findByTxnDatesBetween(startOfLastMonth, endOfLastMonth);
        Map<Customer, List<TimesheetEntry>> customerTimesheets = timesheets.stream()
                .collect(Collectors.groupingBy(entry -> getCustomer(entry.getJobId())));
        Set<Entry<Customer, List<TimesheetEntry>>> entrySet = customerTimesheets.entrySet();
        Iterator<Entry<Customer, List<TimesheetEntry>>> iterator = entrySet.iterator();
        List<Invoice> results = new ArrayList<>();
        while (iterator.hasNext()) {
            Entry<Customer, List<TimesheetEntry>> entry = iterator.next();
            Set<InvoiceLineDetail> detailLines = entry.getValue().stream()
                    .map(t -> toInvoiceLineDetail(t))
                    .collect(Collectors.collectingAndThen(Collectors.toMap(InvoiceLineDetail::getItem, Function.identity(), (left, right) -> {
                        left.setQuantity(left.getQuantity().add(right.getQuantity()));
                        left.setAmount(left.getAmount().add(right.getAmount()));
                        return left;
                    }), m -> new HashSet<>(m.values())));
            Invoice invoice = Invoice.builder()
                    .customer(entry.getKey())
                    .invoiceDate(endOfLastMonth)
                    .dueDate(endOfLastMonth.plusDays(30))
                    .terms(entry.getKey().getTermsRefFullName())
                    .notesForCustomer(format("Airspeed Consulting is a division of 4020774 Manitoba Ltd.%s",
                            System.getProperty("line.separator")))
                    .detailLines(detailLines)
                    .build();
            results.add(invoice);
        }
        
        return results;
    }

    private Customer getCustomer(String jobId) {
        jobCustomerMap.computeIfAbsent(jobId, k -> retrieveCustomerPort
                .findByCustomerId(retrieveCustomerPort.findByCustomerId(jobId).getParentRefListID()));
        return jobCustomerMap.get(jobId);
    }

    private InvoiceLineDetail toInvoiceLineDetail(TimesheetEntry timesheetEntry) {
        BigDecimal quantity = BigDecimal.valueOf(timesheetEntry.getDuration().toMinutes() / 60D);
        ServiceItem item = serviceItemPort.findByServiceItemId(timesheetEntry.getServiceItemId());
        return InvoiceLineDetail.builder()
                .item(Item.builder()
                        .id(timesheetEntry.getServiceItemId())
                        .build())
                .description("Fix me (hours)")
                .quantity(quantity)
                .rate(item.getPrice())
                .amount(quantity.multiply(item.getPrice()).setScale(2, RoundingMode.HALF_UP))
                .build();
    }
}
