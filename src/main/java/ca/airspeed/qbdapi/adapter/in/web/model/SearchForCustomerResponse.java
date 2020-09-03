package ca.airspeed.qbdapi.adapter.in.web.model;

import io.micronaut.core.annotation.Introspected;
import lombok.Builder;
import lombok.Getter;

@Introspected
@Getter
@Builder
public class SearchForCustomerResponse {

    private String id;
    private String fullName;
    private String name;

}
