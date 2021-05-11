package ca.airspeed.qbdapi.adapter.out.persistence.invoice;

import java.util.List;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface InvoiceJpaRepository extends CrudRepository<InvoiceJpaEntity, String> {

    public List<InvoiceJpaEntity> findByRefNumber(String refNumber);
}
