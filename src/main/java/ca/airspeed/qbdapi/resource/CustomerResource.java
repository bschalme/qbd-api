package ca.airspeed.qbdapi.resource;

import java.util.Objects;

import ca.airspeed.qbdapi.domain.Customer;
import io.micronaut.http.hateoas.AbstractResource;

public class CustomerResource extends AbstractResource<CustomerResource> {
    private Customer customer;

    public CustomerResource(Customer customer) {
        super();
        this.customer = Objects.requireNonNull(customer, "'customer' must not be null");
    }
    
    public String getId() {
        return customer.getListID();
    }
    public String getName() {
        return customer.getName();
    }
}
