package ca.airspeed.qbdapi.domain;

import java.math.BigDecimal;
import java.util.Date;

import io.micronaut.core.annotation.Introspected;
import lombok.Builder;
import lombok.Data;

@Data
@Introspected
@Builder
public class Customer {

    private String id;

    private String timeCreated;

    private String timeModified;

    private String editSequence;

    private String name;

    private String fullName;

    private String isActive;

    private String classRefListID;

    private String classRefFullName;

    private String parentRefListID;

    private String parentRefFullName;

    private Integer sublevel;

    private String companyName;

    private String salutation;

    private String firstName;

    private String middleName;

    private String lastName;

    private String jobTitle;

    private String suffix;

    private String billAddressAddr1;

    private String billAddressAddr2;

    private String billAddressAddr3;

    private String billAddressAddr4;

    private String billAddressAddr5;

    private String billAddressCity;

    private String billAddressState;

    private String billAddressPostalCode;

    private String billAddressCountry;

    private String billAddressNote;

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

    private String printAs;

    private String phone;

    private String mobile;

    private String pager;

    private String altPhone;

    private String fax;

    private String email;

    private String cc;

    private String contact;

    private String altContact;

    private String customerTypeRefListID;

    private String customerTypeRefFullName;

    private String termsRefListID;

    private String termsRefFullName;

    private String salesRepRefListID;

    private String salesRepRefFullName;

    private BigDecimal balance;

    private BigDecimal totalBalance;

    private String salesTaxCodeRefListID;

    private String salesTaxCodeRefFullName;

    private String itemSalesTaxRefListID;

    private String itemSalesTaxRefFullName;

    private String salesTaxCountry;

    private String resaleNumber;

    private String accountNumber;

    private BigDecimal creditLimit;

    private String preferredPaymentMethodRefListID;

    private String preferredPaymentMethodRefFullName;

    private String creditCardNumber;

    private Integer expirationMonth;

    private Integer expirationYear;

    private String nameOnCard;

    private String creditCardAddress;

    private String creditCardPostalCode;

    private String jobStatus;

    private Date jobStartDate;

    private Date jobProjectedEndDate;

    private Date jobEndDate;

    private String jobDesc;

    private String jobTypeRefListID;

    private String jobTypeRefFullName;

    private String notes;

    private String priceLevelRefListID;

    private String priceLevelRefFullName;

    private String taxRegistrationNumber;

    private String currencyRefListID;

    private String currencyRefFullName;

    private String isStatementWithParent;

    private String preferredDeliveryMethod;

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
