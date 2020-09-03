package ca.airspeed.qbdapi.adapter.in.web.resource;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.hateoas.AbstractResource;
import lombok.Builder;
import lombok.Data;

@Introspected
@Data
@Builder
public class SearchForCustomerResponseResource extends AbstractResource<SearchForCustomerResponseResource> {

    private String id;
    private String fullName;
    private String name;
}
