package ca.airspeed.qbdapi.adapter.out.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import ca.airspeed.qbdapi.application.port.out.InvoicePort;
import ca.airspeed.qbdapi.domain.Invoice;

@Singleton
public class InvoicePersistenceAdapter implements InvoicePort {

    @Override
    public List<Invoice> findByInvoiceNumber(String invoiceNumber) {
        return new ArrayList<>();
    }

    @Override
    public Invoice findById(String id) {
        return Invoice.builder()
                .build();
    }

}
