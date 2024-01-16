package ca.airspeed.qbdapi.adapter.out.persistence;

import java.math.BigDecimal;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import lombok.Data;

@Entity
@Table(name = "account")
@Data
public class AccountJpaEntity {

    @Id
    @Column(name = "ListID")
    private String listID;

    @Column(name = "TimeCreated")
    private String timeCreated;

    @Column(name = "TimeModified")
    private String timeModified;

//    @Version
    @Column(name = "EditSequence")
    private String editSequence;

    @Column(name = "Name")
    private String name;

    @Column(name = "FullName")
    private String fullName;

    @Column(name = "IsActive")
    private String isActive;

    @Column(name = "ParentRef_ListID")
    private String parentRefListID;

    @Column(name = "ParentRef_FullName")
    private String parentRefFullName;

    @Column(name = "Sublevel")
    private Integer sublevel;

    @Column(name = "AccountType")
    private String accountType;

    @Column(name = "DetailAccountType")
    private String detailAccountType;

    @Column(name = "AccountNumber")
    private String accountNumber;

    @Column(name = "BankNumber")
    private String bankNumber;

    @Column(name = "LastCheckNumber")
    private String lastCheckNumber;

    @Column(name = "Description")
    private String description;

    @Column(name = "Balance")
    private BigDecimal balance;

    @Column(name = "TotalBalance")
    private BigDecimal totalBalance;

    @Column(name = "CashFlowClassification")
    private String cashFlowClassification;

    @Column(name = "SpecialAccountType")
    private String specialAccountType;

    @Column(name = "SalesTaxCodeRef_ListID")
    private String salesTaxCodeRefListID;

    @Column(name = "SalesTaxCodeRef_FullName")
    private String salesTaxCodeRefFullName;

    @Column(name = "IsTaxAccount")
    private String isTaxAccount;

    @Column(name = "TaxLineID")
    private Integer taxLineID;

    @Column(name = "TaxLineInfo")
    private String taxLineInfo;

    @Column(name = "CurrencyRef_ListID")
    private String currencyRefListID;

    @Column(name = "CurrencyRef_FullName")
    private String currencyRefFullName;

    @Column(name = "CustomField1")
    private String customField1;

    @Column(name = "CustomField2")
    private String customField2;

    @Column(name = "CustomField3")
    private String customField3;

    @Column(name = "CustomField4")
    private String customField4;

    @Column(name = "CustomField5")
    private String customField5;

    @Column(name = "CustomField6")
    private String customField6;

    @Column(name = "CustomField7")
    private String customField7;

    @Column(name = "CustomField8")
    private String customField8;

    @Column(name = "CustomField9")
    private String customField9;

    @Column(name = "CustomField10")
    private String customField10;

    @Column(name = "CustomField11")
    private String customField11;

    @Column(name = "CustomField12")
    private String customField12;

    @Column(name = "CustomField13")
    private String customField13;

    @Column(name = "CustomField14")
    private String customField14;

    @Column(name = "CustomField15")
    private String customField15;

    @Column(name = "Status")
    private String status;

}
