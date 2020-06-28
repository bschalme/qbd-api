package ca.airspeed.qbdapi.resource;

import java.util.Objects;

import ca.airspeed.qbdapi.adapter.out.persistence.CustomerJpaEntity;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.hateoas.AbstractResource;
import lombok.extern.slf4j.Slf4j;

@Introspected
@Slf4j
public class CustomerResource extends AbstractResource<CustomerResource> {
    private CustomerJpaEntity customer;

    public CustomerResource() {

    }

    public CustomerResource(CustomerJpaEntity customer) {
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
    
    private CustomerJpaEntity getCustomer() {
        if (customer == null) {
            customer = new CustomerJpaEntity();
        }
        return customer;
    }
}
