package ca.airspeed.qbdapi.application.port.out;

import java.util.List;

import ca.airspeed.qbdapi.domain.Invoice;

public interface InvoicePort {
    List<Invoice> findByInvoiceNumber(String invoiceNumber);

    Invoice findById(String id);

    List<Invoice> findLast();
}
