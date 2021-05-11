package ca.airspeed.qbdapi.adapter.out.persistence.invoice;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface InvoiceJpaRepository extends CrudRepository<InvoiceJpaEntity, String> {

}
