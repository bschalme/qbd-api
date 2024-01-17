package ca.airspeed.qbdapi.adapter.out.persistence.invoice;

import java.util.List;

import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface InvoiceJpaRepository extends CrudRepository<InvoiceJpaEntity, String> {

    public List<InvoiceJpaEntity> findByRefNumber(String refNumber);

    @Query(value = "SELECT * FROM invoice WHERE RefNumber = (SELECT MAX(CONVERT(RefNumber, UNSIGNED INTEGER)) FROM invoice)", nativeQuery = true)
    public List<InvoiceJpaEntity> findlastInvoice();
}
