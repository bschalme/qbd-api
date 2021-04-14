package ca.airspeed.qbdapi.adapter.out.persistence;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface CreditCardChargeJpaRepository extends CrudRepository<CreditCardChargeJpaEntity, String> {

}
