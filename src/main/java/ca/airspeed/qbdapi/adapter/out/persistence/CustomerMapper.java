package ca.airspeed.qbdapi.adapter.out.persistence;

import java.util.Optional;

import javax.inject.Singleton;

import ca.airspeed.qbdapi.domain.Customer;

@Singleton
class CustomerMapper {

    CustomerJpaEntity mapToJpaEntity(Customer customer) {
        CustomerJpaEntity result = new CustomerJpaEntity();
        result.setListID(customer.getId());
        result.setName(customer.getName());
        return result;
    }

    Customer mapToDomainEntity(Optional<CustomerJpaEntity> optional) {
        if (optional.isPresent()) {
            CustomerJpaEntity entity = optional.get();
            return Customer.builder()
                    .id(entity.getListID())
                    .name(entity.getName())
                    .build();
        } else {
            return null;
        }
    }
}
