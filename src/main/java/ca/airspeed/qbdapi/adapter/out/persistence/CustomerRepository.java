package ca.airspeed.qbdapi.adapter.out.persistence;

import java.util.List;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.PageableRepository;

@Repository
public interface CustomerRepository extends PageableRepository<Customer, String> {
    List<Customer> findByIsActive(String isActive);
}
