package ca.airspeed.qbdapi.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ca.airspeed.qbdapi.domain.Customer;

@RepositoryRestResource(path = "customers")
public interface CustomerRepository extends PagingAndSortingRepository<Customer, String> {

}
