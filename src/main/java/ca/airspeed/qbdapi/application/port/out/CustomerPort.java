package ca.airspeed.qbdapi.application.port.out;

import ca.airspeed.qbdapi.domain.Customer;

public interface CustomerPort {

    Customer create(Customer customer);
}
