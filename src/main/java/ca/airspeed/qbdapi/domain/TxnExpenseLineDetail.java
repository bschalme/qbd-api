package ca.airspeed.qbdapi.domain;

import static javax.persistence.FetchType.LAZY;

import java.math.BigDecimal;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.micronaut.core.annotation.Introspected;
import lombok.Builder;
import lombok.Data;

@Data
@Introspected
@Builder
public class TxnExpenseLineDetail {
    private String id;

    private Account account;

    private BigDecimal amount;

    private String memo;

    private String customerRefListID;

    private String customerRefFullName;

    private String classRefListID;

    private String classRefFullName;

    private String salesTaxCodeRefListID;

    private String salesTaxCodeRefFullName;

    private String billableStatus;

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

    private String idKey;

}
