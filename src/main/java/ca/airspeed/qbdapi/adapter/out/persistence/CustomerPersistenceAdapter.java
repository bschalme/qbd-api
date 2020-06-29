package ca.airspeed.qbdapi.adapter.out.persistence;

import javax.inject.Singleton;

import ca.airspeed.qbdapi.application.port.out.RetrieveCustomerPort;
import ca.airspeed.qbdapi.domain.Customer;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
public class CustomerPersistenceAdapter implements RetrieveCustomerPort {
    private final CustomerJpaRepository repo;
    private final CustomerMapper mapper;

    @Override
    public Customer findByCustomerId(String id) {
        return mapper.mapToDomainEntity(repo.findById(id));
    }

}
