package ca.airspeed.qbdapi.adapter.out.persistence.customer;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jakarta.inject.Singleton;

import ca.airspeed.qbdapi.domain.Customer;

@Singleton
class CustomerMapper {

    CustomerJpaEntity mapToJpaEntity(Customer customer) {
        CustomerJpaEntity result = new CustomerJpaEntity();
        result.setListID(customer.getId());
        result.setName(customer.getName());
        result.setFullName(customer.getFullName());
        return result;
    }

    Customer mapToDomainEntity(Optional<CustomerJpaEntity> optional) {
        if (optional.isPresent()) {
            CustomerJpaEntity entity = optional.get();
            return makeDomainEntity(entity);
        } else {
            return null;
        }
    }

    List<Customer> mapToDomainList(List<CustomerJpaEntity> jpaList) {
        if (jpaList != null) {
            return jpaList.stream()
                    .map(CustomerMapper::makeDomainEntity)
                    .collect(toList());
        }
        return new ArrayList<>();
    }

    private static Customer makeDomainEntity(CustomerJpaEntity jpa) {
        return Customer.builder()
                .id(jpa.getListID())
                .name(jpa.getName())
                .fullName(jpa.getFullName())
                .build();
    }
}
