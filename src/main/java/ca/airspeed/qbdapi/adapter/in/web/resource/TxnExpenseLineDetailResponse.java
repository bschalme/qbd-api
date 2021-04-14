package ca.airspeed.qbdapi.adapter.in.web.resource;

import java.math.BigDecimal;

import io.micronaut.core.annotation.Introspected;
import lombok.Data;

@Data
@Introspected
public class TxnExpenseLineDetailResponse {
    private AccountResponse account;
    private BigDecimal amount;

}
