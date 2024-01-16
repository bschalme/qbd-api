package ca.airspeed.qbdapi.adapter.out.persistence;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import lombok.Data;

@Entity
@Table(name = "vendor")
@Data
public class VendorJpaEntity {

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

    @Column(name = "IsActive")
    private String isActive;

    @Column(name = "ClassRef_ListID")
    private String classRefListID;

    @Column(name = "ClassRef_FullName")
    private String classRefFullName;

    @Column(name = "CompanyName")
    private String companyName;

    @Column(name = "Salutation")
    private String salutation;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "MiddleName")
    private String middleName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "JobTitle")
    private String jobTitle;

    @Column(name = "Suffix")
    private String suffix;

    @Column(name = "VendorAddress_Addr1")
    private String vendorAddressAddr1;

    @Column(name = "VendorAddress_Addr2")
    private String vendorAddressAddr2;

    @Column(name = "VendorAddress_Addr3")
    private String vendorAddressAddr3;

    @Column(name = "VendorAddress_Addr4")
    private String vendorAddressAddr4;

    @Column(name = "VendorAddress_Addr5")
    private String vendorAddressAddr5;

    @Column(name = "VendorAddress_City")
    private String vendorAddressCity;

    @Column(name = "VendorAddress_State")
    private String vendorAddressState;

    @Column(name = "VendorAddress_PostalCode")
    private String vendorAddressPostalCode;

    @Column(name = "VendorAddress_Country")
    private String vendorAddressCountry;

    @Column(name = "VendorAddress_Note")
    private String vendorAddressNote;

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

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Mobile")
    private String mobile;

    @Column(name = "Pager")
    private String pager;

    @Column(name = "AltPhone")
    private String altPhone;

    @Column(name = "Fax")
    private String fax;

    @Column(name = "Email")
    private String email;

    @Column(name = "Cc")
    private String cc;

    @Column(name = "Contact")
    private String contact;

    @Column(name = "AltContact")
    private String altContact;

    @Column(name = "NameOnCheck")
    private String nameOnCheck;

    @Column(name = "Notes")
    private String notes;

    @Column(name = "AccountNumber")
    private String accountNumber;

    @Column(name = "VendorTypeRef_ListID")
    private String vendorTypeRefListID;

    @Column(name = "VendorTypeRef_FullName")
    private String vendorTypeRefFullName;

    @Column(name = "TermsRef_ListID")
    private String termsRefListID;

    @Column(name = "TermsRef_FullName")
    private String termsRefFullName;

    @Column(name = "CreditLimit")
    private BigDecimal creditLimit;

    @Column(name = "VendorTaxIdent")
    private String vendorTaxIdent;

    @Column(name = "IsVendorEligibleFor1099")
    private String isVendorEligibleFor1099;

    @Column(name = "Balance")
    private BigDecimal balance;

    @Column(name = "CurrencyRef_ListID")
    private String currencyRefListID;

    @Column(name = "CurrencyRef_FullName")
    private String currencyRefFullName;

    @Column(name = "BillingRateRef_ListID")
    private String billingRateRefListID;

    @Column(name = "BillingRateRef_FullName")
    private String billingRateRefFullName;

    @Column(name = "SalesTaxCodeRef_ListID")
    private String salesTaxCodeRefListID;

    @Column(name = "SalesTaxCodeRef_FullName")
    private String salesTaxCodeRefFullName;

    @Column(name = "SalesTaxCountry")
    private String salesTaxCountry;

    @Column(name = "IsSalesTaxAgency")
    private String isSalesTaxAgency;

    @Column(name = "SalesTaxReturnRef_ListID")
    private String salesTaxReturnRefListID;

    @Column(name = "SalesTaxReturnRef_FullName")
    private String salesTaxReturnRefFullName;

    @Column(name = "TaxRegistrationNumber")
    private String taxRegistrationNumber;

    @Column(name = "ReportingPeriod")
    private String reportingPeriod;

    @Column(name = "IsTaxTrackedOnPurchases")
    private String isTaxTrackedOnPurchases;

    @Column(name = "TaxOnPurchasesAccountRef_ListID")
    private String taxOnPurchasesAccountRefListID;

    @Column(name = "TaxOnPurchasesAccountRef_FullName")
    private String taxOnPurchasesAccountRefFullName;

    @Column(name = "IsTaxTrackedOnSales")
    private String isTaxTrackedOnSales;

    @Column(name = "TaxOnSalesAccountRef_ListID")
    private String taxOnSalesAccountRefListID;

    @Column(name = "TaxOnSalesAccountRef_FullName")
    private String taxOnSalesAccountRefFullName;

    @Column(name = "IsTaxOnTax")
    private String isTaxOnTax;

    @Column(name = "PrefillAccountRef_ListID")
    private String prefillAccountRefListID;

    @Column(name = "PrefillAccountRef_FullName")
    private String prefillAccountRefFullName;

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
