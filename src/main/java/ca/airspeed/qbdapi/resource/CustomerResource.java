package ca.airspeed.qbdapi.resource;

import java.util.Objects;

import ca.airspeed.qbdapi.adapter.out.persistence.Customer;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.hateoas.AbstractResource;
import lombok.extern.slf4j.Slf4j;

@Introspected
@Slf4j
public class CustomerResource extends AbstractResource<CustomerResource> {
    private Customer customer;

    public CustomerResource() {

    }

    public CustomerResource(Customer customer) {
        super();
        log.debug("customer is {}", customer);
        this.customer = Objects.requireNonNull(customer, "'customer' must not be null");
    }

    public String getId() {
        return customer.getListID();
    }

    public void setId(String id) {
        getCustomer().setListID(id);
    }

    public String getName() {
        return customer.getName();
    }

    public void setName(String name) {
        getCustomer().setName(name);
    }
    
    private Customer getCustomer() {
        if (customer == null) {
            customer = new Customer();
        }
        return customer;
    }
}
