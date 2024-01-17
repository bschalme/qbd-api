package ca.airspeed.qbdapi.adapter.out.persistence;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "currency")
@Data
public class CurrencyJpaEntity {

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

    @Column(name = "IsActive")
    private String isActive;

    @Column(name = "CurrencyCode")
    private String currencyCode;

    @Column(name = "ThousandSeparator")
    private String thousandSeparator;

    @Column(name = "ThousandSeparatorGrouping")
    private String thousandSeparatorGrouping;

    @Column(name = "DecimalPlaces")
    private String decimalPlaces;

    @Column(name = "DecimalSeparator")
    private String decimalSeparator;

    @Column(name = "IsUserDefinedCurrency")
    private String isUserDefinedCurrency;

    @Column(name = "ExchangeRate")
    private Float exchangeRate;

    @Column(name = "AsOfDate")
    private Date asOfDate;

    @Column(name = "Status")
    private String status;

}
