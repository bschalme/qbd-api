package ca.airspeed.qbdapi.domain;

import java.math.BigDecimal;

import io.micronaut.core.annotation.Introspected;
import lombok.Builder;
import lombok.Data;

@Data
@Introspected
@Builder
public class ServiceItem {
    private String id;
    private Integer version;
    private String name;
    private String fullName;
    private String description;
    private BigDecimal price;
}
