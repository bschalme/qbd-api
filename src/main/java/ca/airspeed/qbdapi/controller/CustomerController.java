package ca.airspeed.qbdapi.controller;

import static io.micronaut.http.hateoas.Link.SELF;
import static java.lang.String.format;

import java.util.ArrayList;
import java.util.List;

import ca.airspeed.qbdapi.domain.Customer;
import ca.airspeed.qbdapi.repository.CustomerRepository;
import ca.airspeed.qbdapi.resource.AllCustomersResource;
import ca.airspeed.qbdapi.resource.CustomerResource;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.hateoas.Resource;
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
    public AllCustomersResource findAllCustomers() {
        log.debug("Received a request for findAllCustomers().");
        List<Resource> resources = new ArrayList<>();
        for (Customer customer: repo.findAll()) {
            CustomerResource resource = new CustomerResource(customer);
            resource.link(SELF, format("/customers/%s", customer.getListID()));
            resources.add(resource);
        }
        AllCustomersResource allCustomers = new AllCustomersResource();
        allCustomers.link(SELF, "/customers");
        allCustomers.embedded("customers", resources);
        return allCustomers;
    }
}
