package ca.airspeed.qbdapi.adapter.out.persistence.itemservice;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import ca.airspeed.qbdapi.adapter.out.persistence.SalesOrPurchaseDetailJpaEntity;
import io.micronaut.core.annotation.Introspected;
import lombok.Data;

@Entity
@Table(name = "itemservice")
@Data
@Introspected
public class ItemServiceJpaEntity {

    @Id
    @Column(name = "ListID")
    private String listID;

    @Column(name = "TimeCreated")
    private String timeCreated;

    @Column(name = "TimeModified")
    private String timeModified;

    @Column(name = "EditSequence")
    private String editSequence;

    @Column(name = "Name")
    private String name;

    @Column(name = "FullName")
    private String fullName;

    @Column(name = "BarCodeValue")
    private String barCodeValue;

    @Column(name = "IsActive")
    private String isActive;

    @Column(name = "ClassRef_ListID")
    private String classRefListID;

    @Column(name = "ClassRef_FullName")
    private String classRefFullName;

    @Column(name = "ParentRef_ListID")
    private String parentRefListID;

    @Column(name = "ParentRef_FullName")
    private String parentRefFullName;

    @Column(name = "Sublevel")
    private Integer sublevel;

    @Column(name = "UnitOfMeasureSetRef_ListID")
    private String unitOfMeasureSetRefListID;

    @Column(name = "UnitOfMeasureSetRef_FullName")
    private String unitOfMeasureSetRefFullName;

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

    @OneToOne
    @JoinColumn(name = "ListID", referencedColumnName = "IDKEY")
    private SalesOrPurchaseDetailJpaEntity detail;

    @Column(name = "Status")
    private String status;

}
