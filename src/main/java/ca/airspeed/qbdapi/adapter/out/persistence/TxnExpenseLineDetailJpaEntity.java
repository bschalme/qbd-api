package ca.airspeed.qbdapi.adapter.out.persistence;

import static javax.persistence.ConstraintMode.NO_CONSTRAINT;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "txnexpenselinedetail")
@Data
public class TxnExpenseLineDetailJpaEntity {

    @Id
    @Column(name = "TxnLineID")
    private String txnLineID;

    @ManyToOne
    @JoinColumn(name = "AccountRef_ListID",
            referencedColumnName = "ListID",
            insertable = true, 
            updatable = true, 
            foreignKey = @javax.persistence.ForeignKey(value = NO_CONSTRAINT))
    private AccountJpaEntity account;

    @Column(name = "AccountRef_FullName")
    private String accountRefFullName;

    @Column(name = "Amount")
    private BigDecimal amount;

    @Column(name = "Memo")
    private String memo;

    @Column(name = "CustomerRef_ListID")
    private String customerRefListID;

    @Column(name = "CustomerRef_FullName")
    private String customerRefFullName;

    @Column(name = "ClassRef_ListID")
    private String classRefListID;

    @Column(name = "ClassRef_FullName")
    private String classRefFullName;

    @Column(name = "SalesTaxCodeRef_ListID")
    private String salesTaxCodeRefListID;

    @Column(name = "SalesTaxCodeRef_FullName")
    private String salesTaxCodeRefFullName;

    @Column(name = "BillableStatus")
    private String billableStatus;

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

//    @ManyToOne(fetch = LAZY, optional = false)
//    @JoinColumn(name = "IDKEY", nullable = false)
//    private CreditCardChargeJpaEntity creditCardCharge;
    @Column(name = "IDKEY")
    private String idKey;
}
