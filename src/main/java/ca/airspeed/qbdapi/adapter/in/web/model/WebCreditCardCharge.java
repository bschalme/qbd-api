package ca.airspeed.qbdapi.adapter.in.web.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import io.micronaut.core.annotation.Introspected;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Introspected
public class WebCreditCardCharge {
    private WebAccount account;
    private WebVendor payee;
    private LocalDate txnDate;

    @Size(max = 11)
    private String refNumber;
    private BigDecimal amount;
    private String memo;
    private Set<WebTxnExpenseLineDetail> expenseLines;
}
