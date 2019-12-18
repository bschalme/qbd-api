package ca.airspeed.qbdapi.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.micronaut.http.hateoas.Resource;
import lombok.Data;

@Entity
@Table(name = "customer")
@Data
public class Customer implements Resource {

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

    @Column(name = "PrintAs")
    private String printAs;

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

    @Column(name = "CustomerTypeRef_ListID")
    private String customerTypeRefListID;

    @Column(name = "CustomerTypeRef_FullName")
    private String customerTypeRefFullName;

    @Column(name = "TermsRef_ListID")
    private String termsRefListID;

    @Column(name = "TermsRef_FullName")
    private String termsRefFullName;

    @Column(name = "SalesRepRef_ListID")
    private String salesRepRefListID;

    @Column(name = "SalesRepRef_FullName")
    private String salesRepRefFullName;

    @Column(name = "Balance")
    private BigDecimal balance;

    @Column(name = "TotalBalance")
    private BigDecimal totalBalance;

    @Column(name = "SalesTaxCodeRef_ListID")
    private String salesTaxCodeRefListID;

    @Column(name = "SalesTaxCodeRef_FullName")
    private String salesTaxCodeRefFullName;

    @Column(name = "ItemSalesTaxRef_ListID")
    private String itemSalesTaxRefListID;

    @Column(name = "ItemSalesTaxRef_FullName")
    private String itemSalesTaxRefFullName;

    @Column(name = "SalesTaxCountry")
    private String salesTaxCountry;

    @Column(name = "ResaleNumber")
    private String resaleNumber;

    @Column(name = "AccountNumber")
    private String accountNumber;

    @Column(name = "CreditLimit")
    private BigDecimal creditLimit;

    @Column(name = "PreferredPaymentMethodRef_ListID")
    private String preferredPaymentMethodRefListID;

    @Column(name = "PreferredPaymentMethodRef_FullName")
    private String preferredPaymentMethodRefFullName;

    @Column(name = "CreditCardNumber")
    private String creditCardNumber;

    @Column(name = "ExpirationMonth")
    private Integer expirationMonth;

    @Column(name = "ExpirationYear")
    private Integer expirationYear;

    @Column(name = "NameOnCard")
    private String nameOnCard;

    @Column(name = "CreditCardAddress")
    private String creditCardAddress;

    @Column(name = "CreditCardPostalCode")
    private String creditCardPostalCode;

    @Column(name = "JobStatus")
    private String jobStatus;

    @Column(name = "JobStartDate")
    private Date jobStartDate;

    @Column(name = "JobProjectedEndDate")
    private Date jobProjectedEndDate;

    @Column(name = "JobEndDate")
    private Date jobEndDate;

    @Column(name = "JobDesc")
    private String jobDesc;

    @Column(name = "JobTypeRef_ListID")
    private String jobTypeRefListID;

    @Column(name = "JobTypeRef_FullName")
    private String jobTypeRefFullName;

    @Column(name = "Notes")
    private String notes;

    @Column(name = "PriceLevelRef_ListID")
    private String priceLevelRefListID;

    @Column(name = "PriceLevelRef_FullName")
    private String priceLevelRefFullName;

    @Column(name = "TaxRegistrationNumber")
    private String taxRegistrationNumber;

    @Column(name = "CurrencyRef_ListID")
    private String currencyRefListID;

    @Column(name = "CurrencyRef_FullName")
    private String currencyRefFullName;

    @Column(name = "IsStatementWithParent")
    private String isStatementWithParent;

    @Column(name = "PreferredDeliveryMethod")
    private String preferredDeliveryMethod;

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
