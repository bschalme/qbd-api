package ca.airspeed.qbdapi.application.service;

import java.util.List;

import javax.inject.Singleton;

import ca.airspeed.qbdapi.application.port.in.RetrieveInvoiceUseCase;
import ca.airspeed.qbdapi.application.port.in.SearchForInvoiceUseCase;
import ca.airspeed.qbdapi.application.port.out.InvoicePort;
import ca.airspeed.qbdapi.domain.Invoice;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
public class InvoiceService implements RetrieveInvoiceUseCase, SearchForInvoiceUseCase {

    private final InvoicePort invoicePort;

    @Override
    public List<Invoice> findByInvoiceNumber(String invoiceNumber) {
        return invoicePort.findByInvoiceNumber(invoiceNumber);
    }

    @Override
    public Invoice retrieveInvoice(String id) {
        return invoicePort.findById(id);
    }

}
