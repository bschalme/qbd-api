package ca.airspeed.qbdapi.adapter.out.persistence.invoice;

import static javax.persistence.ConstraintMode.NO_CONSTRAINT;
import static javax.persistence.FetchType.EAGER;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ca.airspeed.qbdapi.adapter.out.persistence.customer.CustomerJpaEntity;
import io.micronaut.core.annotation.Introspected;
import lombok.Data;

@Entity
@Table(name = "invoice")
@Data
@Introspected
public class InvoiceJpaEntity {

    public InvoiceJpaEntity() {
        detailLines = new HashSet<>();
    }

    @Id
    @Column(name = "TxnID")
    private String txnID;

    @Column(name = "TimeCreated")
    private String timeCreated;

    @Column(name = "TimeModified")
    private String timeModified;

    @Column(name = "EditSequence")
    private String editSequence;

    @Column(name = "TxnNumber")
    private Integer txnNumber;

    @ManyToOne
    @JoinColumn(name = "CustomerRef_ListID",
            referencedColumnName = "ListID",
            insertable = true, 
            updatable = true, 
            foreignKey = @javax.persistence.ForeignKey(value = NO_CONSTRAINT))
    private CustomerJpaEntity customer;

    @Column(name = "CustomerRef_FullName")
    private String customerRefFullName;

    @Column(name = "ClassRef_ListID")
    private String classRefListID;

    @Column(name = "ClassRef_FullName")
    private String classRefFullName;

    @Column(name = "ARAccountRef_ListID")
    private String aRAccountRefListID;

    @Column(name = "ARAccountRef_FullName")
    private String aRAccountRefFullName;

    @Column(name = "TemplateRef_ListID")
    private String templateRefListID;

    @Column(name = "TemplateRef_FullName")
    private String templateRefFullName;

    @Column(name = "TxnDate")
    private Date txnDate;

    @Column(name = "RefNumber")
    private String refNumber;

    @Column(name = "BillAddress_Addr1")
    private String billAddressAddr1;

    @Column(name = "BillAddress_Addr2")
    private String billAddressAddr2;

    @Column(name = "BillAddress_Addr3")
    private String billAddressAddr3;

    @Column(name = "BillAddress_Addr4")
    private String billAddressAddr4;

    @Column(name = "BillAddress_Addr5")
    private String billAddressAddr5;

    @Column(name = "BillAddress_City")
    private String billAddressCity;

    @Column(name = "BillAddress_State")
    private String billAddressState;

    @Column(name = "BillAddress_PostalCode")
    private String billAddressPostalCode;

    @Column(name = "BillAddress_Country")
    private String billAddressCountry;

    @Column(name = "BillAddress_Note")
    private String billAddressNote;

    @Column(name = "ShipAddress_Addr1")
    private String shipAddressAddr1;

    @Column(name = "ShipAddress_Addr2")
    private String shipAddressAddr2;

    @Column(name = "ShipAddress_Addr3")
    private String shipAddressAddr3;

    @Column(name = "ShipAddress_Addr4")
    private String shipAddressAddr4;

    @Column(name = "ShipAddress_Addr5")
    private String shipAddressAddr5;

    @Column(name = "ShipAddress_City")
    private String shipAddressCity;

    @Column(name = "ShipAddress_State")
    private String shipAddressState;

    @Column(name = "ShipAddress_PostalCode")
    private String shipAddressPostalCode;

    @Column(name = "ShipAddress_Country")
    private String shipAddressCountry;

    @Column(name = "ShipAddress_Note")
    private String shipAddressNote;

    @Column(name = "IsPending")
    private String isPending;

    @Column(name = "IsFinanceCharge")
    private String isFinanceCharge;

    @Column(name = "PONumber")
    private String poNumber;

    @Column(name = "TermsRef_ListID")
    private String termsRefListID;

    @Column(name = "TermsRef_FullName")
    private String termsRefFullName;

    @Column(name = "DueDate")
    private Date dueDate;

    @Column(name = "SalesRepRef_ListID")
    private String salesRepRefListID;

    @Column(name = "SalesRepRef_FullName")
    private String salesRepRefFullName;

    @Column(name = "FOB")
    private String fOB;

    @Column(name = "ShipDate")
    private Date shipDate;

    @Column(name = "ShipMethodRef_ListID")
    private String shipMethodRefListID;

    @Column(name = "ShipMethodRef_FullName")
    private String shipMethodRefFullName;

    @Column(name = "Subtotal")
    private BigDecimal subtotal;

    @Column(name = "ItemSalesTaxRef_ListID")
    private String itemSalesTaxRefListID;

    @Column(name = "ItemSalesTaxRef_FullName")
    private String itemSalesTaxRefFullName;

    @Column(name = "SalesTaxPercentage")
    private String salesTaxPercentage;

    @Column(name = "SalesTaxTotal")
    private BigDecimal salesTaxTotal;

    @Column(name = "AppliedAmount")
    private BigDecimal appliedAmount;

    @Column(name = "BalanceRemaining")
    private BigDecimal balanceRemaining;

    @Column(name = "CurrencyRef_ListID")
    private String currencyRefListID;

    @Column(name = "CurrencyRef_FullName")
    private String currencyRefFullName;

    @Column(name = "ExchangeRate")
    private Float exchangeRate;

    @Column(name = "BalanceRemainingInHomeCurrency")
    private BigDecimal balanceRemainingInHomeCurrency;

    @Column(name = "Memo")
    private String memo;

    @Column(name = "IsPaid")
    private String isPaid;

    @Column(name = "CustomerMsgRef_ListID")
    private String customerMsgRefListID;

    @Column(name = "CustomerMsgRef_FullName")
    private String customerMsgRefFullName;

    @Column(name = "IsToBePrinted")
    private String isToBePrinted;

    @Column(name = "IsToBeEmailed")
    private String isToBeEmailed;

    @Column(name = "IsTaxIncluded")
    private String isTaxIncluded;

    @Column(name = "CustomerSalesTaxCodeRef_ListID")
    private String customerSalesTaxCodeRefListID;

    @Column(name = "CustomerSalesTaxCodeRef_FullName")
    private String customerSalesTaxCodeRefFullName;

    @Column(name = "SuggestedDiscountAmount")
    private BigDecimal suggestedDiscountAmount;

    @Column(name = "SuggestedDiscountDate")
    private Date suggestedDiscountDate;

    @Column(name = "Other")
    private String other;

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

    @OneToMany(fetch = EAGER)
    @JoinColumn(name = "IDKEY",
            insertable = true, 
            updatable = true, 
            foreignKey = @javax.persistence.ForeignKey(value = NO_CONSTRAINT))
    private Set<InvoiceLineDetailJpaEntity> detailLines;
}
