package ca.airspeed.qbdapi.application.service;

import ca.airspeed.qbdapi.application.port.out.InvoicePort;
import ca.airspeed.qbdapi.application.port.out.RetrieveCustomerPort;
import ca.airspeed.qbdapi.application.port.out.ServiceItemPort;
import ca.airspeed.qbdapi.application.port.out.TimesheetPort;
import ca.airspeed.qbdapi.domain.Customer;
import ca.airspeed.qbdapi.domain.Invoice;
import ca.airspeed.qbdapi.domain.InvoiceLineDetail;
import ca.airspeed.qbdapi.domain.ServiceItem;
import ca.airspeed.qbdapi.domain.TimesheetEntry;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InvoiceServiceUnitTest {

    @InjectMocks
    private InvoiceService service;

    @Mock
    private InvoicePort mockInvoicePort;

    @Mock
    private TimesheetPort mockTimesheetPort;

    @Mock
    private RetrieveCustomerPort mockRetrieveCustomerPort;

    @Mock
    private ServiceItemPort mockServiceItemPort;

    @Test
    void retrieveInvoice() throws Exception {
        // Given:
        Invoice invoice = Invoice.builder()
                .id("ABC-123")
                .invoiceNumber("609")
                .build();
        when(mockInvoicePort.findById(eq("ABC-123"))).thenReturn(invoice);

        // When:
        Invoice result = service.retrieveInvoice("ABC-123");

        // Then:
        assertThat("Resulting Invoice;", result, notNullValue());
        assertThat("Invoice ID;", result.getId(), is("ABC-123"));
        assertThat("Invoice Number;", result.getInvoiceNumber(), is("609"));
    }

    @Test
    void findByInvoiceNumber() throws Exception {
        // Given:
        Invoice invoice = Invoice.builder()
                .id("ABC-123")
                .invoiceNumber("609")
                .build();
        when(mockInvoicePort.findByInvoiceNumber(eq("609"))).thenReturn(List.of(invoice));

        // When:
        List<Invoice> results = service.findByInvoiceNumber("609");

        // Then:
        assertThat("Result set;", results, hasSize(1));
        Invoice result = results.get(0);
        assertThat("Invoice ID;", result.getId(), is("ABC-123"));
        assertThat("Invoice Number;", result.getInvoiceNumber(), is("609"));
    }

    @Test
    void generateTimeAndMaterialsInvoices() throws Exception {
        // Given:
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
        LocalDate endOfLastMonth = oneMonthAgo.plusMonths(1).withDayOfMonth(1).minusDays(1);
        TimesheetEntry time1 = TimesheetEntry.builder()
                .dateWorked(oneMonthAgo.withDayOfMonth(2))
                .associateId("Jack-123")
                .jobId("EastIndia-345")
                .serviceItemId("ShipRepair-875")
                .duration(Duration.ofMinutes(90))
                .billableStatus("Billable")
                .build();
        TimesheetEntry time2 = TimesheetEntry.builder()
                .dateWorked(oneMonthAgo.withDayOfMonth(2))
                .associateId("Jack-123")
                .jobId("EastIndia-345")
                .serviceItemId("ShipRepair-875")
                .duration(Duration.ofMinutes(105))
                .billableStatus("Billable")
                .build();
        when(mockTimesheetPort.findByTxnDatesBetween(oneMonthAgo.withDayOfMonth(1),
                endOfLastMonth))
                .thenReturn(List.of(time1, time2));
        when(mockRetrieveCustomerPort.findByCustomerId("EastIndia-345")).thenReturn(Customer.builder()
                .id("EastIndia-345")
                .parentRefListID("EastIndia-123")
                .build());
        when(mockRetrieveCustomerPort.findByCustomerId("EastIndia-123")).thenReturn(Customer.builder()
                .id("EastIndia-123")
                .name("East India Company")
                .termsRefFullName("Net 30")
                .build());
        when(mockServiceItemPort.findByServiceItemId("ShipRepair-875")).thenReturn(ServiceItem.builder()
                .id("ShipRepair-875")
                .price(BigDecimal.valueOf(95.50))
                .build());

        // When:
        List<Invoice> results = service.generateTimeAndMaterialsInvoices();

        // Then:
        assertThat("Generated Invoices;", results, hasSize(1));
        Invoice invoice = results.get(0);
        assertThat("Customer;", invoice.getCustomer(), notNullValue());
        assertThat("Customer ID;", invoice.getCustomer().getId(), is("EastIndia-123"));
        assertThat("Invoice Date;", invoice.getInvoiceDate(), is(endOfLastMonth));
        assertThat("Invoice Due Date;", invoice.getDueDate(), is(endOfLastMonth.plusDays(30)));
        assertThat("Invoice Terms;", invoice.getTerms(), is("Net 30"));
        assertThat("Invoice Notes;", invoice.getNotesForCustomer(), not(emptyOrNullString()));
        String[] notes = invoice.getNotesForCustomer().split(System.getProperty("line.separator"));
        assertThat("First line of notes;", notes[0], is("Airspeed Consulting is a division of 4020774 Manitoba Ltd."));

        Set<InvoiceLineDetail> details = invoice.getDetailLines();
        assertThat("Invoice details;", details, hasSize(1));
        InvoiceLineDetail detail = details.iterator().next();
        assertThat("Detail Item;", detail.getItem(), notNullValue());
        assertThat(detail.getItem().getId(), is("ShipRepair-875"));
        assertThat("Quantity;", detail.getQuantity(), closeTo(BigDecimal.valueOf(3.25), BigDecimal.valueOf(0.005D)));
        assertThat("Rate;", detail.getRate(), closeTo(BigDecimal.valueOf(95.5), BigDecimal.valueOf(0.005D)));
        assertThat("Amount;", detail.getAmount(), closeTo(BigDecimal.valueOf(310.38), BigDecimal.valueOf(0.001D)));
    }
}
