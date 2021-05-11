package ca.airspeed.qbdapi.adapter.out.persistence.invoice;

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
        return InvoiceJpaMapper.INSTANCE.jpaEntitiesToInvoices(repo.findByRefNumber(invoiceNumber));
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
