package ca.airspeed.qbdapi.adapter.out.persistence.invoice;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import io.micronaut.core.annotation.Introspected;
import lombok.Data;

@Entity
@Table(name = "invoicelinedetail")
@Data
@Introspected
public class InvoiceLineDetailJpaEntity {

    @Id
    @Column(name = "TxnLineID")
    private String txnLineID;

    @Column(name = "ItemRef_ListID")
    private String itemRefListID;

    @Column(name = "ItemRef_FullName")
    private String itemRefFullName;

    @Column(name = "Description")
    private String description;

    @Column(name = "Quantity")
    private String quantity;

    @Column(name = "UnitOfMeasure")
    private String unitOfMeasure;

    @Column(name = "OverrideUOMSetRef_ListID")
    private String overrideUOMSetRefListID;

    @Column(name = "OverrideUOMSetRef_FullName")
    private String overrideUOMSetRefFullName;

    @Column(name = "Rate")
    private String rate;

    @Column(name = "RatePercent")
    private String ratePercent;

    @Column(name = "ClassRef_ListID")
    private String classRefListID;

    @Column(name = "ClassRef_FullName")
    private String classRefFullName;

    @Column(name = "Amount")
    private BigDecimal amount;

    @Column(name = "InventorySiteRef_ListID")
    private String inventorySiteRefListID;

    @Column(name = "InventorySiteRef_FullName")
    private String inventorySiteRefFullName;

    @Column(name = "InventorySiteLocationRef_ListID")
    private String inventorySiteLocationRefListID;

    @Column(name = "InventorySiteLocationRef_FullName")
    private String inventorySiteLocationRefFullName;

    @Column(name = "SerialNumber")
    private String serialNumber;

    @Column(name = "LotNumber")
    private String lotNumber;

    @Column(name = "ServiceDate")
    private Date serviceDate;

    @Column(name = "SalesTaxCodeRef_ListID")
    private String salesTaxCodeRefListID;

    @Column(name = "SalesTaxCodeRef_FullName")
    private String salesTaxCodeRefFullName;

    @Column(name = "Other1")
    private String other1;

    @Column(name = "Other2")
    private String other2;

    @Column(name = "LinkedTxnID")
    private String linkedTxnID;

    @Column(name = "LinkedTxnLineID")
    private String linkedTxnLineID;

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

    @Column(name = "GroupIDKEY")
    private String groupIDKEY;

}
