package ca.airspeed.qbdapi.repository;

import java.util.List;

import ca.airspeed.qbdapi.domain.Customer;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.PageableRepository;

@Repository
public interface CustomerRepository extends PageableRepository<Customer, String> {
    List<Customer> findByIsActive(String isActive);
}
