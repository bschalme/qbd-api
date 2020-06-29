package ca.airspeed.qbdapi.adapter.in.web;

import static io.micronaut.http.hateoas.Link.SELF;
import static java.lang.String.format;

import java.util.ArrayList;
import java.util.List;

import ca.airspeed.qbdapi.adapter.out.persistence.CustomerJpaEntity;
import ca.airspeed.qbdapi.adapter.out.persistence.CustomerJpaRepository;
import ca.airspeed.qbdapi.application.port.in.RetrieveCustomerUseCase;
import ca.airspeed.qbdapi.domain.Customer;
import ca.airspeed.qbdapi.resource.CustomerResource;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import lombok.extern.slf4j.Slf4j;

@Controller("/customers")
@Slf4j
public class CustomerController {

    private CustomerJpaRepository repo;
    private RetrieveCustomerUseCase service;

    public CustomerController(RetrieveCustomerUseCase service) {
        super();
        this.service = service;
    }

    public Page<CustomerResource> findAllCustomers(Pageable pageable) {
        log.info("Received a request for findAllCustomers().");
        log.debug("Pageable size is {}.", pageable.getSize());
        List<CustomerResource> resources = new ArrayList<>();
        Page<CustomerJpaEntity> customers = repo.findAll(pageable);
        log.debug("Found {} Customers.", customers.getContent().size());
        for (CustomerJpaEntity customer: customers.getContent()) {
            CustomerResource resource = new CustomerResource(customer);
            resource.link(SELF, format("/customers/%s", customer.getListID()));
            resources.add(resource);
        }
        Page<CustomerResource> result = Page.of(resources, pageable, resources.size());
        List<CustomerResource> content = result.getContent();
        int contentSize = content == null ? 0 : content.size();
        log.debug("Resulting Page numberOfElements: {}, size of content: {}, offset = {}.",
                result.getNumberOfElements(), contentSize, result.getOffset());
        return result;
    }

    @Get("/{customerId}")
    public CustomerResource findOneCustomer(String customerId) {
        log.info("Received a request for findOneCustomer().");
        Customer customer = service.retrieveCustomer(customerId);
        if (customer == null) {
            return null;
        }
        else {
            CustomerResource result = new CustomerResource();
            result.link(SELF, format("/customers/%s", customer.getId()));
            result.setId(customer.getId());
            result.setName(customer.getName());
            return result;
        }
    }
}
