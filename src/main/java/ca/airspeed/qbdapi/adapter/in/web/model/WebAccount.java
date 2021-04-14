package ca.airspeed.qbdapi.adapter.in.web.model;

import io.micronaut.core.annotation.Introspected;
import lombok.Data;

@Data
@Introspected
public class WebAccount {
    private String id;
    private String name;
    private String fullName;
}
