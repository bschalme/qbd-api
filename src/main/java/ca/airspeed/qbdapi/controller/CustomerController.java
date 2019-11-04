package ca.airspeed.qbdapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/customers")
public class CustomerController {
    private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);

    @Get("/")
    public String findAllCustomers() {
        LOG.debug("Received a request for findAllCustomers().");
        return "{\"customer\":\"MegaCorp Inc.\"}";
    }
}
