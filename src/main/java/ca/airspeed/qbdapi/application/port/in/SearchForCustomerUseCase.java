package ca.airspeed.qbdapi.application.port.in;

import java.util.List;

import ca.airspeed.qbdapi.domain.Customer;

public interface SearchForCustomerUseCase {

    List<Customer> findByFullName(String fullName);
}
