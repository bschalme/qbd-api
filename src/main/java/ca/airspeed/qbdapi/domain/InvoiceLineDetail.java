package ca.airspeed.qbdapi.domain;

import java.math.BigDecimal;

import io.micronaut.core.annotation.Introspected;
import lombok.Builder;
import lombok.Data;

@Data
@Introspected
@Builder
public class InvoiceLineDetail {
    private String id;
    private ServiceItem serviceItem; 
    private String description;
    private BigDecimal quantity;
}
