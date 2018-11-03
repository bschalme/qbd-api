package ca.airspeed.qbdapi.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ca.airspeed.qbdapi.domain.Customer;

@RepositoryRestResource(path = "customers")
public interface CustomerRepository extends PagingAndSortingRepository<Customer, String> {
    List<Customer> findByIsActive(@Param("isActive") String isActive);
}
