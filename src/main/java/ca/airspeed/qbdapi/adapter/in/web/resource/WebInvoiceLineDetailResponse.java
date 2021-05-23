package ca.airspeed.qbdapi.adapter.in.web.resource;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WebInvoiceLineDetailResponse {
    private String id;
    private WebItemResponse item; 
    private String description;
    private BigDecimal quantity;
    private BigDecimal rate;
    private BigDecimal amount;
}
