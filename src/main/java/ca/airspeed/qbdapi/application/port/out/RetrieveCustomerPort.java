package ca.airspeed.qbdapi.application.port.out;

import ca.airspeed.qbdapi.domain.Customer;

public interface RetrieveCustomerPort {

    public Customer findByCustomerId(String id);
}
