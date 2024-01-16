package ca.airspeed.qbdapi.adapter.out.persistence.cheque;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.Table;

import ca.airspeed.qbdapi.domain.DividendYear;
import io.micronaut.core.annotation.Introspected;
import lombok.Data;

@Entity
@Table(name = "\"check\"")
@Data
@Introspected
@SqlResultSetMapping(
        name="Statement-SQL-Mapping",
        classes = {
                @ConstructorResult(targetClass = DividendYear.class,
                        columns = {
                                @ColumnResult(name="Year",type = Integer.class),
                                @ColumnResult(name="Amount",type = BigDecimal.class)
                        }
                )
        }
)
public class ChequeJpaEntity {

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

    @Column(name = "AccountRef_ListID")
    private String accountRefListID;

    @Column(name = "AccountRef_FullName")
    private String accountRefFullName;

    @Column(name = "PayeeEntityRef_ListID")
    private String payeeEntityRefListID;

    @Column(name = "PayeeEntityRef_FullName")
    private String payeeEntityRefFullName;

    @Column(name = "RefNumber")
    private String refNumber;

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

    @Column(name = "Memo")
    private String memo;

    @Column(name = "Address_Addr1")
    private String addressAddr1;

    @Column(name = "Address_Addr2")
    private String addressAddr2;

    @Column(name = "Address_Addr3")
    private String addressAddr3;

    @Column(name = "Address_Addr4")
    private String addressAddr4;

    @Column(name = "Address_Addr5")
    private String addressAddr5;

    @Column(name = "Address_City")
    private String addressCity;

    @Column(name = "Address_State")
    private String addressState;

    @Column(name = "Address_PostalCode")
    private String addressPostalCode;

    @Column(name = "Address_Country")
    private String addressCountry;

    @Column(name = "Address_Note")
    private String addressNote;

    @Column(name = "IsToBePrinted")
    private String isToBePrinted;

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

}
