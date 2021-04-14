package ca.airspeed.qbdapi.adapter.out.persistence;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import io.micronaut.core.annotation.Introspected;
import lombok.Data;

@Entity
@Table(name = "creditcardcharge")
@Data
@Introspected
public class CreditCardChargeJpaEntity {

    @Id
    @Column(name = "TxnID")
    private String txnID;

    @Column(name = "TimeCreated")
    private String timeCreated;

    @Column(name = "TimeModified")
    private String timeModified;

//    @Version
    @Column(name = "EditSequence")
    private String editSequence;

    @Column(name = "TxnNumber")
    private Integer txnNumber;

    @OneToOne
    @JoinColumn(name = "AccountRef_ListID", referencedColumnName = "ListID")
    private AccountJpaEntity account;

    @Column(name = "AccountRef_FullName")
    private String accountRefFullName;

    @OneToOne
    @JoinColumn(name = "PayeeEntityRef_ListID", referencedColumnName = "ListID")
    private VendorJpaEntity payee;

    @Column(name = "PayeeEntityRef_FullName")
    private String payeeEntityRefFullName;

    @Column(name = "TxnDate")
    private Date txnDate;

    @Column(name = "Amount")
    private BigDecimal amount;

    @Column(name = "CurrencyRef_ListID")
    private String currencyRefListID;

    @Column(name = "CurrencyRef_FullName")
    private String currencyRefFullName;

    @Column(name = "ExchangeRate")
    private Float exchangeRate;

    @Column(name = "AmountInHomeCurrency")
    private BigDecimal amountInHomeCurrency;

    @Column(name = "RefNumber")
    private String refNumber;

    @Column(name = "Memo")
    private String memo;

    @Column(name = "IsTaxIncluded")
    private String isTaxIncluded;

    @Column(name = "SalesTaxCodeRef_ListID")
    private String salesTaxCodeRefListID;

    @Column(name = "SalesTaxCodeRef_FullName")
    private String salesTaxCodeRefFullName;

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

//    @OneToMany(cascade = ALL, fetch = EAGER)
//    @JoinColumn(name = "IDKEY")
    @Transient
    private Set<TxnExpenseLineDetailJpaEntity> expenseLines;
}
