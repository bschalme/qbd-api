package ca.airspeed.qbdapi.adapter.out.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Singleton;

import ca.airspeed.qbdapi.application.port.out.InvoicePort;
import ca.airspeed.qbdapi.domain.Invoice;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
public class InvoicePersistenceAdapter implements InvoicePort {

    private final InvoiceJpaRepository repo; 

    @Override
    public List<Invoice> findByInvoiceNumber(String invoiceNumber) {
        return new ArrayList<>();
    }

    @Override
    public Invoice findById(String id) {
        Optional<InvoiceJpaEntity> entityOptional = repo.findById(id);
        if (entityOptional.isPresent() ) {
            return InvoiceJpaMapper.INSTANCE.jpaEntityToInvoice(entityOptional.get());
        }
        return null;
    }

}
