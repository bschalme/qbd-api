package ca.airspeed.qbdapi.adapter.in.web.resource;

import io.micronaut.core.annotation.Introspected;
import lombok.Data;

@Data
@Introspected
public class VendorResponse {
    private String id;
    private String name;
    private String fullName;
}
