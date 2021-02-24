package ca.airspeed.qbdapi.adapter.in.web.resource;

import java.math.BigDecimal;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.hateoas.AbstractResource;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Introspected
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class SearchForServiceItemResponseResource extends AbstractResource<SearchForServiceItemResponseResource> {
    private String id;
    private String name;
    private String fullName;
    private String description;
    private BigDecimal price;
}
