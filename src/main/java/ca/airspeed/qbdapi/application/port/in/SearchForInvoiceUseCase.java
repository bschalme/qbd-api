package ca.airspeed.qbdapi.application.port.in;

import java.util.List;

import ca.airspeed.qbdapi.domain.Invoice;

public interface SearchForInvoiceUseCase {
    List<Invoice> findByInvoiceNumber(String invoiceNumber);
}
