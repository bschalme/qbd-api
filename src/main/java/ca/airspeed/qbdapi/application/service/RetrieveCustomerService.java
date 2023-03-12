package ca.airspeed.qbdapi.application.service;

import jakarta.inject.Singleton;

import ca.airspeed.qbdapi.application.port.in.RetrieveCustomerUseCase;
import ca.airspeed.qbdapi.application.port.out.RetrieveCustomerPort;
import ca.airspeed.qbdapi.domain.Customer;
import io.micronaut.core.annotation.Introspected;

@Singleton
@Introspected
public class RetrieveCustomerService implements RetrieveCustomerUseCase {

    private RetrieveCustomerPort customerPort;

    public RetrieveCustomerService(RetrieveCustomerPort customerPort) {
        super();
        this.customerPort = customerPort;
    }

    @Override
    public Customer retrieveCustomer(String id) {
        return customerPort.findByCustomerId(id);
    }

}
