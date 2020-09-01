package ca.airspeed.qbdapi.application.port.out;

import java.util.List;

import ca.airspeed.qbdapi.domain.Customer;

public interface SearchForCustomerPort {

    List<Customer> findByFullName(String fullName);
}
