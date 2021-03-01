package ca.airspeed.qbdapi.application.port.in;

import ca.airspeed.qbdapi.domain.Customer;

public interface RetrieveCustomerUseCase {

    Customer retrieveCustomer(String id);
}
