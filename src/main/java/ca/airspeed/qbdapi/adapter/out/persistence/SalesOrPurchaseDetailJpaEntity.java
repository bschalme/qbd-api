package ca.airspeed.qbdapi.adapter.out.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import io.micronaut.core.annotation.Introspected;
import lombok.Data;

@Entity
@Table(name = "salesorpurchasedetail")
@Data
@Introspected
public class SalesOrPurchaseDetailJpaEntity {
    @Column(name = "Description")
    private String description;

    @Column(name = "Price")
    private String price;

    @Column(name = "PricePercent")
    private String pricePercent;

    @Column(name = "AccountRef_ListID")
    private String accountRefListID;

    @Column(name = "AccountRef_FullName")
    private String accountRefFullName;

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

    @Id
    @Column(name = "IDKEY")
    private String idKeyY;

    @Column(name = "GroupIDKEY")
    private String groupIDKEY;

}
