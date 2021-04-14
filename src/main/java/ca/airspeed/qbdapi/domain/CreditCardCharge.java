package ca.airspeed.qbdapi.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.micronaut.core.annotation.Introspected;
import lombok.Builder;
import lombok.Data;

@Data
@Introspected
@Builder
public class CreditCardCharge {

    @Pattern(regexp = "[A-Za-z0-9-]+")
    @Size(min = 1, max = 36)
    private String id;

    private String timeCreated;

    private String timeModified;

    private String editSequence;

    private Account account;

    private Vendor payee;

    private LocalDate txnDate;

    private BigDecimal amount;

    private String currencyRefListID;

    private String currencyRefFullName;

    private Float exchangeRate;

    private BigDecimal amountInHomeCurrency;

    private String refNumber;

    private String memo;

    private String isTaxIncluded;

    private String salesTaxCodeRefListID;

    private String salesTaxCodeRefFullName;

    private String customField1;

    private String customField2;

    private String customField3;

    private String customField4;

    private String customField5;

    private String customField6;

    private String customField7;

    private String customField8;

    private String customField9;

    private String customField10;

    private String customField11;

    private String customField12;

    private String customField13;

    private String customField14;

    private String customField15;

    private Set<TxnExpenseLineDetail> expenseLines;
}
