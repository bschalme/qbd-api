package ca.airspeed.qbdapi.application.port.in;

import ca.airspeed.qbdapi.domain.Customer;

public interface CreateCustomerUseCase {
    Customer createCustomer(Customer customer);

}
