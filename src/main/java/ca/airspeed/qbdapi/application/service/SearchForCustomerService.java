package ca.airspeed.qbdapi.application.service;

import java.util.List;

import javax.inject.Singleton;

import ca.airspeed.qbdapi.application.port.in.SearchForCustomerUseCase;
import ca.airspeed.qbdapi.application.port.out.SearchForCustomerPort;
import ca.airspeed.qbdapi.domain.Customer;
import io.micronaut.core.annotation.Introspected;

@Singleton
@Introspected
public class SearchForCustomerService implements SearchForCustomerUseCase {

    private SearchForCustomerPort customerPort;

    public SearchForCustomerService(SearchForCustomerPort customerPort) {
        super();
        this.customerPort = customerPort;
    }

    @Override
    public List<Customer> findByFullName(String fullName) {
        return customerPort.findByFullName(fullName);
    }

}
