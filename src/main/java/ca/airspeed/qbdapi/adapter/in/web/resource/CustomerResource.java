package ca.airspeed.qbdapi.adapter.in.web.resource;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.hateoas.AbstractResource;
import lombok.Data;

@Introspected
@Data
public class CustomerResource extends AbstractResource<CustomerResource> {

    private String id;
    private String fullName;
    private String name;
}
