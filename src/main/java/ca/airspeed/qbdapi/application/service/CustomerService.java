package ca.airspeed.qbdapi.application.service;

import java.util.UUID;

import jakarta.inject.Singleton;

import ca.airspeed.qbdapi.application.port.in.CreateCustomerUseCase;
import ca.airspeed.qbdapi.application.port.out.CustomerPort;
import ca.airspeed.qbdapi.domain.Customer;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
public class CustomerService implements CreateCustomerUseCase {
    private final CustomerPort port;

    @Override
    public Customer createCustomer(Customer customer) {
        customer.setId(UUID.randomUUID().toString());
        return port.create(customer);
    }

}
