package ca.airspeed.qbdapi.resource;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.hateoas.AbstractResource;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Introspected
@Slf4j
@Data
public class CustomerResource extends AbstractResource<CustomerResource> {

    private String id;
    private String fullName;
    private String name;
}
