package ca.airspeed.qbdapi.adapter.in.web.resource;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WebItemResponse {
    private String id;
    private String name;
    private String fullName;
    private String description;
    private BigDecimal price;

}
