package ca.airspeed.qbdapi.controller;

import static io.micronaut.http.hateoas.Link.SELF;
import static java.lang.String.format;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ca.airspeed.qbdapi.domain.Customer;
import ca.airspeed.qbdapi.repository.CustomerRepository;
import ca.airspeed.qbdapi.resource.CustomerResource;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import lombok.extern.slf4j.Slf4j;

@Controller("/customers")
@Slf4j
public class CustomerController {

    private CustomerRepository repo;

    public CustomerController(CustomerRepository repo) {
        super();
        this.repo = repo;
    }

    @Get("/")
    public Page<CustomerResource> findAllCustomers(Pageable pageable) {
        log.info("Received a request for findAllCustomers().");
        log.debug("Pageable size is {}.", pageable.getSize());
        List<CustomerResource> resources = new ArrayList<>();
        Page<Customer> customers = repo.findAll(pageable);
        log.debug("Found {} Customers.", customers.getContent().size());
        for (Customer customer: customers.getContent()) {
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
        Optional<Customer> result = repo.findById(customerId);
        if (result.isPresent()) {
            log.debug("result.get() is {}", result.get());
            CustomerResource resource = new CustomerResource(result.get());
            resource.link(SELF, format("/customers/%s", result.get().getListID()));
            log.debug("Returning the CustomerResource");
            return resource;
        }
        else {
            return null;
        }
    }
}
