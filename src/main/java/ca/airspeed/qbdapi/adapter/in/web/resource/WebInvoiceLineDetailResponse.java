package ca.airspeed.qbdapi.adapter.in.web.resource;

import java.math.BigDecimal;

import ca.airspeed.qbdapi.domain.ServiceItem;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WebInvoiceLineDetailResponse {
    private String id;
    private ServiceItem serviceItem; 
    private String description;
    private BigDecimal quantity;
}
