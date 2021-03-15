package ca.airspeed.qbdapi.adapter.in.web;

import static io.micronaut.http.hateoas.Link.SELF;
import static java.lang.String.format;

import java.util.ArrayList;
import java.util.List;

import ca.airspeed.qbdapi.adapter.in.web.resource.CustomerResource;
import ca.airspeed.qbdapi.adapter.in.web.resource.SearchForCustomerResponseResource;
import ca.airspeed.qbdapi.application.port.in.RetrieveCustomerUseCase;
import ca.airspeed.qbdapi.application.port.in.SearchForCustomerUseCase;
import ca.airspeed.qbdapi.domain.Customer;
import io.micronaut.context.annotation.Value;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.authentication.Authentication;
import lombok.extern.slf4j.Slf4j;

@Controller("/customers")
@Slf4j
@Secured({"MyGroup"})
public class CustomerController {

    private SearchForCustomerUseCase searchForCustomer;
    private RetrieveCustomerUseCase retrieveCustomer;

    @Value("${micronaut.server.context-path:}")
    private String serverContextPath;

    public CustomerController(SearchForCustomerUseCase searchForCustomer, RetrieveCustomerUseCase retrieveCustomer) {
        super();
        this.searchForCustomer = searchForCustomer;
        this.retrieveCustomer = retrieveCustomer;
    }

    /**
     * Searches for Customers by their Full Name.
     * 
     * @param fullName
     *            the first few characters of the Customer's Full Name.
     * @return a list of matching Customers.
     */
    @Get("/")
    @ExecuteOn(TaskExecutors.IO)
    public List<SearchForCustomerResponseResource> searchByFullNameStartingWith(@QueryValue String fullName) {
        List<Customer> data = searchForCustomer.findByFullName(fullName);
        List<SearchForCustomerResponseResource> results = new ArrayList<>();
        if (data == null) {
            return results;
        }
        for (Customer customer : data) {
            SearchForCustomerResponseResource result = SearchForCustomerResponseResource.builder()
                    .id(customer.getId())
                    .name(customer.getName())
                    .fullName(customer.getFullName())
                    .build();
            result.link(SELF, format("%s/customers/%s", serverContextPath, customer.getId()));
            results.add(result);
        }
        return results;
    }

    /**
     * Retrieve one Customer.
     * 
     * @param customerId
     *            the Customer's unique identifier.
     * @return the matching Customer.
     */
    @Get("/{customerId}")
    @ExecuteOn(TaskExecutors.IO)
    public CustomerResource findOneCustomer(String customerId, Authentication authn) {
        Customer customer = retrieveCustomer.retrieveCustomer(customerId);
        if (customer == null) {
            log.info("Principal '{}' asked for customer ID '{}', but was not found.", authn.getName(), customerId);
            return null;
        }
        else {
            log.info("Principal '{}' asked for and received customer ID '{}', name '{}'.", authn.getName(), customerId,
                    customer.getFullName());
            CustomerResource result = new CustomerResource();
            result.link(SELF, format("%s/customers/%s", serverContextPath, customer.getId()));
            result.setId(customer.getId());
            result.setFullName(customer.getFullName());
            result.setName(customer.getName());
            return result;
        }
    }
}
