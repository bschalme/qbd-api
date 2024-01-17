package ca.airspeed.qbdapi.application.port.in;

import java.util.List;

import ca.airspeed.qbdapi.domain.Invoice;

public interface RetrieveInvoiceUseCase {
    Invoice retrieveInvoice(String id);

    List<Invoice> retrieveLastInvoice();
}
