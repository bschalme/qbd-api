package ca.airspeed.qbdapi.application.port.in;

import ca.airspeed.qbdapi.domain.Invoice;

public interface RetrieveInvoiceUseCase {
    Invoice retrieveInvoice(String id);
}
