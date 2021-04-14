package ca.airspeed.qbdapi.adapter.in.web.resource;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.hateoas.AbstractResource;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Introspected
@Data
@EqualsAndHashCode(callSuper = false)
public class CreditCardChargeResponseResource extends AbstractResource<CreditCardChargeResponseResource> {

    private String id;
    private AccountResponse account;
    private VendorResponse payee;
    private LocalDate txnDate;
    private String refNumber;
    private BigDecimal amount;
    private String memo;
    private Set<TxnExpenseLineDetailResponse> expenseLines;

}
