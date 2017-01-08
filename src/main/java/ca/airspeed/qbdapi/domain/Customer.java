package ca.airspeed.qbdapi.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

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

    public String getListID() {
        return listID;
    }

    public void setListID(String listID) {
        this.listID = listID;
    }

    public String getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(String timeCreated) {
        this.timeCreated = timeCreated;
    }

    public String getTimeModified() {
        return timeModified;
    }

    public void setTimeModified(String timeModified) {
        this.timeModified = timeModified;
    }

    public String getEditSequence() {
        return editSequence;
    }

    public void setEditSequence(String editSequence) {
        this.editSequence = editSequence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getClassRefListID() {
        return classRefListID;
    }

    public void setClassRefListID(String classRefListID) {
        this.classRefListID = classRefListID;
    }

    public String getClassRefFullName() {
        return classRefFullName;
    }

    public void setClassRefFullName(String classRefFullName) {
        this.classRefFullName = classRefFullName;
    }

    public String getParentRefListID() {
        return parentRefListID;
    }

    public void setParentRefListID(String parentRefListID) {
        this.parentRefListID = parentRefListID;
    }

    public String getParentRefFullName() {
        return parentRefFullName;
    }

    public void setParentRefFullName(String parentRefFullName) {
        this.parentRefFullName = parentRefFullName;
    }

    public Integer getSublevel() {
        return sublevel;
    }

    public void setSublevel(Integer sublevel) {
        this.sublevel = sublevel;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getBillAddressAddr1() {
        return billAddressAddr1;
    }

    public void setBillAddressAddr1(String billAddressAddr1) {
        this.billAddressAddr1 = billAddressAddr1;
    }

    public String getBillAddressAddr2() {
        return billAddressAddr2;
    }

    public void setBillAddressAddr2(String billAddressAddr2) {
        this.billAddressAddr2 = billAddressAddr2;
    }

    public String getBillAddressAddr3() {
        return billAddressAddr3;
    }

    public void setBillAddressAddr3(String billAddressAddr3) {
        this.billAddressAddr3 = billAddressAddr3;
    }

    public String getBillAddressAddr4() {
        return billAddressAddr4;
    }

    public void setBillAddressAddr4(String billAddressAddr4) {
        this.billAddressAddr4 = billAddressAddr4;
    }

    public String getBillAddressAddr5() {
        return billAddressAddr5;
    }

    public void setBillAddressAddr5(String billAddressAddr5) {
        this.billAddressAddr5 = billAddressAddr5;
    }

    public String getBillAddressCity() {
        return billAddressCity;
    }

    public void setBillAddressCity(String billAddressCity) {
        this.billAddressCity = billAddressCity;
    }

    public String getBillAddressState() {
        return billAddressState;
    }

    public void setBillAddressState(String billAddressState) {
        this.billAddressState = billAddressState;
    }

    public String getBillAddressPostalCode() {
        return billAddressPostalCode;
    }

    public void setBillAddressPostalCode(String billAddressPostalCode) {
        this.billAddressPostalCode = billAddressPostalCode;
    }

    public String getBillAddressCountry() {
        return billAddressCountry;
    }

    public void setBillAddressCountry(String billAddressCountry) {
        this.billAddressCountry = billAddressCountry;
    }

    public String getBillAddressNote() {
        return billAddressNote;
    }

    public void setBillAddressNote(String billAddressNote) {
        this.billAddressNote = billAddressNote;
    }

    public String getShipAddressAddr1() {
        return shipAddressAddr1;
    }

    public void setShipAddressAddr1(String shipAddressAddr1) {
        this.shipAddressAddr1 = shipAddressAddr1;
    }

    public String getShipAddressAddr2() {
        return shipAddressAddr2;
    }

    public void setShipAddressAddr2(String shipAddressAddr2) {
        this.shipAddressAddr2 = shipAddressAddr2;
    }

    public String getShipAddressAddr3() {
        return shipAddressAddr3;
    }

    public void setShipAddressAddr3(String shipAddressAddr3) {
        this.shipAddressAddr3 = shipAddressAddr3;
    }

    public String getShipAddressAddr4() {
        return shipAddressAddr4;
    }

    public void setShipAddressAddr4(String shipAddressAddr4) {
        this.shipAddressAddr4 = shipAddressAddr4;
    }

    public String getShipAddressAddr5() {
        return shipAddressAddr5;
    }

    public void setShipAddressAddr5(String shipAddressAddr5) {
        this.shipAddressAddr5 = shipAddressAddr5;
    }

    public String getShipAddressCity() {
        return shipAddressCity;
    }

    public void setShipAddressCity(String shipAddressCity) {
        this.shipAddressCity = shipAddressCity;
    }

    public String getShipAddressState() {
        return shipAddressState;
    }

    public void setShipAddressState(String shipAddressState) {
        this.shipAddressState = shipAddressState;
    }

    public String getShipAddressPostalCode() {
        return shipAddressPostalCode;
    }

    public void setShipAddressPostalCode(String shipAddressPostalCode) {
        this.shipAddressPostalCode = shipAddressPostalCode;
    }

    public String getShipAddressCountry() {
        return shipAddressCountry;
    }

    public void setShipAddressCountry(String shipAddressCountry) {
        this.shipAddressCountry = shipAddressCountry;
    }

    public String getShipAddressNote() {
        return shipAddressNote;
    }

    public void setShipAddressNote(String shipAddressNote) {
        this.shipAddressNote = shipAddressNote;
    }

    public String getPrintAs() {
        return printAs;
    }

    public void setPrintAs(String printAs) {
        this.printAs = printAs;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPager() {
        return pager;
    }

    public void setPager(String pager) {
        this.pager = pager;
    }

    public String getAltPhone() {
        return altPhone;
    }

    public void setAltPhone(String altPhone) {
        this.altPhone = altPhone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAltContact() {
        return altContact;
    }

    public void setAltContact(String altContact) {
        this.altContact = altContact;
    }

    public String getCustomerTypeRefListID() {
        return customerTypeRefListID;
    }

    public void setCustomerTypeRefListID(String customerTypeRefListID) {
        this.customerTypeRefListID = customerTypeRefListID;
    }

    public String getCustomerTypeRefFullName() {
        return customerTypeRefFullName;
    }

    public void setCustomerTypeRefFullName(String customerTypeRefFullName) {
        this.customerTypeRefFullName = customerTypeRefFullName;
    }

    public String getTermsRefListID() {
        return termsRefListID;
    }

    public void setTermsRefListID(String termsRefListID) {
        this.termsRefListID = termsRefListID;
    }

    public String getTermsRefFullName() {
        return termsRefFullName;
    }

    public void setTermsRefFullName(String termsRefFullName) {
        this.termsRefFullName = termsRefFullName;
    }

    public String getSalesRepRefListID() {
        return salesRepRefListID;
    }

    public void setSalesRepRefListID(String salesRepRefListID) {
        this.salesRepRefListID = salesRepRefListID;
    }

    public String getSalesRepRefFullName() {
        return salesRepRefFullName;
    }

    public void setSalesRepRefFullName(String salesRepRefFullName) {
        this.salesRepRefFullName = salesRepRefFullName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(BigDecimal totalBalance) {
        this.totalBalance = totalBalance;
    }

    public String getSalesTaxCodeRefListID() {
        return salesTaxCodeRefListID;
    }

    public void setSalesTaxCodeRefListID(String salesTaxCodeRefListID) {
        this.salesTaxCodeRefListID = salesTaxCodeRefListID;
    }

    public String getSalesTaxCodeRefFullName() {
        return salesTaxCodeRefFullName;
    }

    public void setSalesTaxCodeRefFullName(String salesTaxCodeRefFullName) {
        this.salesTaxCodeRefFullName = salesTaxCodeRefFullName;
    }

    public String getItemSalesTaxRefListID() {
        return itemSalesTaxRefListID;
    }

    public void setItemSalesTaxRefListID(String itemSalesTaxRefListID) {
        this.itemSalesTaxRefListID = itemSalesTaxRefListID;
    }

    public String getItemSalesTaxRefFullName() {
        return itemSalesTaxRefFullName;
    }

    public void setItemSalesTaxRefFullName(String itemSalesTaxRefFullName) {
        this.itemSalesTaxRefFullName = itemSalesTaxRefFullName;
    }

    public String getSalesTaxCountry() {
        return salesTaxCountry;
    }

    public void setSalesTaxCountry(String salesTaxCountry) {
        this.salesTaxCountry = salesTaxCountry;
    }

    public String getResaleNumber() {
        return resaleNumber;
    }

    public void setResaleNumber(String resaleNumber) {
        this.resaleNumber = resaleNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getPreferredPaymentMethodRefListID() {
        return preferredPaymentMethodRefListID;
    }

    public void setPreferredPaymentMethodRefListID(String preferredPaymentMethodRefListID) {
        this.preferredPaymentMethodRefListID = preferredPaymentMethodRefListID;
    }

    public String getPreferredPaymentMethodRefFullName() {
        return preferredPaymentMethodRefFullName;
    }

    public void setPreferredPaymentMethodRefFullName(String preferredPaymentMethodRefFullName) {
        this.preferredPaymentMethodRefFullName = preferredPaymentMethodRefFullName;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public Integer getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(Integer expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public Integer getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(Integer expirationYear) {
        this.expirationYear = expirationYear;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public String getCreditCardAddress() {
        return creditCardAddress;
    }

    public void setCreditCardAddress(String creditCardAddress) {
        this.creditCardAddress = creditCardAddress;
    }

    public String getCreditCardPostalCode() {
        return creditCardPostalCode;
    }

    public void setCreditCardPostalCode(String creditCardPostalCode) {
        this.creditCardPostalCode = creditCardPostalCode;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public Date getJobStartDate() {
        return jobStartDate;
    }

    public void setJobStartDate(Date jobStartDate) {
        this.jobStartDate = jobStartDate;
    }

    public Date getJobProjectedEndDate() {
        return jobProjectedEndDate;
    }

    public void setJobProjectedEndDate(Date jobProjectedEndDate) {
        this.jobProjectedEndDate = jobProjectedEndDate;
    }

    public Date getJobEndDate() {
        return jobEndDate;
    }

    public void setJobEndDate(Date jobEndDate) {
        this.jobEndDate = jobEndDate;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public String getJobTypeRefListID() {
        return jobTypeRefListID;
    }

    public void setJobTypeRefListID(String jobTypeRefListID) {
        this.jobTypeRefListID = jobTypeRefListID;
    }

    public String getJobTypeRefFullName() {
        return jobTypeRefFullName;
    }

    public void setJobTypeRefFullName(String jobTypeRefFullName) {
        this.jobTypeRefFullName = jobTypeRefFullName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getPriceLevelRefListID() {
        return priceLevelRefListID;
    }

    public void setPriceLevelRefListID(String priceLevelRefListID) {
        this.priceLevelRefListID = priceLevelRefListID;
    }

    public String getPriceLevelRefFullName() {
        return priceLevelRefFullName;
    }

    public void setPriceLevelRefFullName(String priceLevelRefFullName) {
        this.priceLevelRefFullName = priceLevelRefFullName;
    }

    public String getTaxRegistrationNumber() {
        return taxRegistrationNumber;
    }

    public void setTaxRegistrationNumber(String taxRegistrationNumber) {
        this.taxRegistrationNumber = taxRegistrationNumber;
    }

    public String getCurrencyRefListID() {
        return currencyRefListID;
    }

    public void setCurrencyRefListID(String currencyRefListID) {
        this.currencyRefListID = currencyRefListID;
    }

    public String getCurrencyRefFullName() {
        return currencyRefFullName;
    }

    public void setCurrencyRefFullName(String currencyRefFullName) {
        this.currencyRefFullName = currencyRefFullName;
    }

    public String getIsStatementWithParent() {
        return isStatementWithParent;
    }

    public void setIsStatementWithParent(String isStatementWithParent) {
        this.isStatementWithParent = isStatementWithParent;
    }

    public String getPreferredDeliveryMethod() {
        return preferredDeliveryMethod;
    }

    public void setPreferredDeliveryMethod(String preferredDeliveryMethod) {
        this.preferredDeliveryMethod = preferredDeliveryMethod;
    }

    public String getCustomField1() {
        return customField1;
    }

    public void setCustomField1(String customField1) {
        this.customField1 = customField1;
    }

    public String getCustomField2() {
        return customField2;
    }

    public void setCustomField2(String customField2) {
        this.customField2 = customField2;
    }

    public String getCustomField3() {
        return customField3;
    }

    public void setCustomField3(String customField3) {
        this.customField3 = customField3;
    }

    public String getCustomField4() {
        return customField4;
    }

    public void setCustomField4(String customField4) {
        this.customField4 = customField4;
    }

    public String getCustomField5() {
        return customField5;
    }

    public void setCustomField5(String customField5) {
        this.customField5 = customField5;
    }

    public String getCustomField6() {
        return customField6;
    }

    public void setCustomField6(String customField6) {
        this.customField6 = customField6;
    }

    public String getCustomField7() {
        return customField7;
    }

    public void setCustomField7(String customField7) {
        this.customField7 = customField7;
    }

    public String getCustomField8() {
        return customField8;
    }

    public void setCustomField8(String customField8) {
        this.customField8 = customField8;
    }

    public String getCustomField9() {
        return customField9;
    }

    public void setCustomField9(String customField9) {
        this.customField9 = customField9;
    }

    public String getCustomField10() {
        return customField10;
    }

    public void setCustomField10(String customField10) {
        this.customField10 = customField10;
    }

    public String getCustomField11() {
        return customField11;
    }

    public void setCustomField11(String customField11) {
        this.customField11 = customField11;
    }

    public String getCustomField12() {
        return customField12;
    }

    public void setCustomField12(String customField12) {
        this.customField12 = customField12;
    }

    public String getCustomField13() {
        return customField13;
    }

    public void setCustomField13(String customField13) {
        this.customField13 = customField13;
    }

    public String getCustomField14() {
        return customField14;
    }

    public void setCustomField14(String customField14) {
        this.customField14 = customField14;
    }

    public String getCustomField15() {
        return customField15;
    }

    public void setCustomField15(String customField15) {
        this.customField15 = customField15;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
