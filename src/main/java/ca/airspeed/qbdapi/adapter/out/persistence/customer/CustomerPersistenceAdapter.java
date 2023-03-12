package ca.airspeed.qbdapi.adapter.out.persistence.customer;

import java.util.List;
import java.util.Optional;

import jakarta.inject.Singleton;

import ca.airspeed.qbdapi.application.port.out.CustomerPort;
import ca.airspeed.qbdapi.application.port.out.RetrieveCustomerPort;
import ca.airspeed.qbdapi.application.port.out.SearchForCustomerPort;
import ca.airspeed.qbdapi.domain.Customer;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
public class CustomerPersistenceAdapter implements CustomerPort, RetrieveCustomerPort, SearchForCustomerPort {
    private final CustomerJpaRepository repo;
    private final CustomerMapper mapper;

    @Override
    public Customer findByCustomerId(String id) {
        return mapper.mapToDomainEntity(repo.findById(id));
    }

    @Override
    public List<Customer> findByFullName(String fullName) {
        List<CustomerJpaEntity> resultSet = repo.findByFullNameStartsWith(fullName);
        return mapper.mapToDomainList(resultSet);
    }

    @Override
    public Customer create(Customer customer) {
        CustomerJpaEntity entity = mapper.mapToJpaEntity(customer);
        return mapper.mapToDomainEntity(Optional.of(repo.save(entity)));
    }

}
