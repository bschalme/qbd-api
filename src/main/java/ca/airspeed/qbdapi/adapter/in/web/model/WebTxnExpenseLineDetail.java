package ca.airspeed.qbdapi.adapter.in.web.model;

import java.math.BigDecimal;

import io.micronaut.core.annotation.Introspected;
import lombok.Data;

@Data
@Introspected
public class WebTxnExpenseLineDetail {
    private WebAccount account;
    private BigDecimal amount;
}
