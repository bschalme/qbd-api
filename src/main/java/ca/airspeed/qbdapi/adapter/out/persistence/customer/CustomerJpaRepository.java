package ca.airspeed.qbdapi.adapter.out.persistence.customer;

import java.util.List;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.PageableRepository;

@Repository
public interface CustomerJpaRepository extends PageableRepository<CustomerJpaEntity, String> {
    List<CustomerJpaEntity> findByIsActive(String isActive);

    List<CustomerJpaEntity> findByFullNameStartsWith(String fullName);
}
