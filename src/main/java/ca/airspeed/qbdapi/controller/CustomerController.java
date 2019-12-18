package ca.airspeed.qbdapi.controller;

import static io.micronaut.http.hateoas.Link.SELF;
import static java.lang.String.format;
import static java.util.Arrays.asList;

import ca.airspeed.qbdapi.domain.Customer;
import ca.airspeed.qbdapi.resource.AllCustomersResource;
import ca.airspeed.qbdapi.resource.CustomerResource;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import lombok.extern.slf4j.Slf4j;

@Controller("/customers")
@Slf4j
public class CustomerController {

    @Get("/")
    public AllCustomersResource findAllCustomers() {
        log.debug("Received a request for findAllCustomers().");
        Customer megaCorp = new Customer();
        megaCorp.setName("MegaCorp Inc");
        megaCorp.setListID("1");
        CustomerResource megaCorpResource = new CustomerResource(megaCorp);
        megaCorpResource.link(SELF, format("/customers/%s", megaCorp.getListID()));
        Customer littleBiz = new Customer();
        littleBiz.setListID("2");
        littleBiz.setName("Little Biz");
        CustomerResource littleBizResource = new CustomerResource(littleBiz);
        littleBizResource.link(SELF, format("/customers/%s", littleBiz.getListID()));
        AllCustomersResource allCustomers = new AllCustomersResource();
        allCustomers.link(SELF, "/customers");
        allCustomers.embedded("customers", asList(megaCorpResource, littleBizResource));
        return allCustomers;
    }
}
