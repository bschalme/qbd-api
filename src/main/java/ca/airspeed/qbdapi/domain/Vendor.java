package ca.airspeed.qbdapi.domain;

import java.math.BigDecimal;

import io.micronaut.core.annotation.Introspected;
import lombok.Builder;
import lombok.Data;

@Data
@Introspected
@Builder
public class Vendor {
    private String id;

    private String timeCreated;

    private String timeModified;

    private String editSequence;

    private String name;

    private String isActive;

    private String classRefListID;

    private String classRefFullName;

    private String companyName;

    private String salutation;

    private String firstName;

    private String middleName;

    private String lastName;

    private String jobTitle;

    private String suffix;

    private String vendorAddressAddr1;

    private String vendorAddressAddr2;

    private String vendorAddressAddr3;

    private String vendorAddressAddr4;

    private String vendorAddressAddr5;

    private String vendorAddressCity;

    private String vendorAddressState;

    private String vendorAddressPostalCode;

    private String vendorAddressCountry;

    private String vendorAddressNote;

    private String shipAddressAddr1;

    private String shipAddressAddr2;

    private String shipAddressAddr3;

    private String shipAddressAddr4;

    private String shipAddressAddr5;

    private String shipAddressCity;

    private String shipAddressState;

    private String shipAddressPostalCode;

    private String shipAddressCountry;

    private String shipAddressNote;

    private String phone;

    private String mobile;

    private String pager;

    private String altPhone;

    private String fax;

    private String email;

    private String cc;

    private String contact;

    private String altContact;

    private String nameOnCheck;

    private String notes;

    private String accountNumber;

    private String vendorTypeRefListID;

    private String vendorTypeRefFullName;

    private String termsRefListID;

    private String termsRefFullName;

    private BigDecimal creditLimit;

    private String vendorTaxIdent;

    private String isVendorEligibleFor1099;

    private BigDecimal balance;

    private String currencyRefListID;

    private String currencyRefFullName;

    private String billingRateRefListID;

    private String billingRateRefFullName;

    private String salesTaxCodeRefListID;

    private String salesTaxCodeRefFullName;

    private String salesTaxCountry;

    private String isSalesTaxAgency;

    private String salesTaxReturnRefListID;

    private String salesTaxReturnRefFullName;

    private String taxRegistrationNumber;

    private String reportingPeriod;

    private String isTaxTrackedOnPurchases;

    private String taxOnPurchasesAccountRefListID;

    private String taxOnPurchasesAccountRefFullName;

    private String isTaxTrackedOnSales;

    private String taxOnSalesAccountRefListID;

    private String taxOnSalesAccountRefFullName;

    private String isTaxOnTax;

    private String prefillAccountRefListID;

    private String prefillAccountRefFullName;

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

    private String status;


}
