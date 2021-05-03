package ca.airspeed.qbdapi.adapter.in.web.resource;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ca.airspeed.qbdapi.domain.Customer;

@Mapper
public interface WebCustomerResourceMapper {

    public static final WebCustomerResourceMapper INSTANCE = Mappers.getMapper(WebCustomerResourceMapper.class);

    CustomerResource domainObjectToWebCustomerResource(Customer customer);
}
