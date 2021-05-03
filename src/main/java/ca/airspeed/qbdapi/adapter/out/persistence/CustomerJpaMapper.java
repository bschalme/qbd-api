package ca.airspeed.qbdapi.adapter.out.persistence;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import ca.airspeed.qbdapi.domain.Customer;

@Mapper
public interface CustomerJpaMapper {

    public static CustomerJpaMapper INSTANCE = Mappers.getMapper(CustomerJpaMapper.class);

    @Mapping(source = "listID", target = "id")
    Customer jpaEntityToCustomer(CustomerJpaEntity entity);

    List<Customer> jpaEntitiesToCustomers(List<CustomerJpaEntity> entities);
}
