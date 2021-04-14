package ca.airspeed.qbdapi.domain;

import java.math.BigDecimal;

import io.micronaut.core.annotation.Introspected;
import lombok.Builder;
import lombok.Data;

@Data
@Introspected
@Builder
public class Account {
    private String id;

    private String timeCreated;

    private String timeModified;

    private String editSequence;

    private String name;

    private String fullName;

    private String isActive;

    private String parentRefListID;

    private String parentRefFullName;

    private Integer sublevel;

    private String accountType;

    private String detailAccountType;

    private String accountNumber;

    private String bankNumber;

    private String lastCheckNumber;

    private String description;

    private BigDecimal balance;

    private BigDecimal totalBalance;

    private String cashFlowClassification;

    private String specialAccountType;

    private String salesTaxCodeRefListID;

    private String salesTaxCodeRefFullName;

    private String isTaxAccount;

    private Integer taxLineID;

    private String taxLineInfo;

    private String currencyRefListID;

    private String currencyRefFullName;

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

}
