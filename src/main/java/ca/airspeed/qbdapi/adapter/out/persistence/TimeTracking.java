package ca.airspeed.qbdapi.adapter.out.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.micronaut.core.annotation.Introspected;

@Entity
@Table(name = "timetracking")
@Introspected
public class TimeTracking {

    @Id
    @Column(name = "TxnID")
    private String txnId;

    @Column(name = "TimeCreated")
    private String timeCreated;

    @Column(name = "TimeModified")
    private String timeModified;

    @Column(name = "EditSequence")
    private String editSequence;

    @Column(name = "TxnNumber")
    private Integer txnNumber;

    @Column(name = "TxnDate")
    private Date txnDate;

    @Column(name = "EntityRef_ListID")
    private String entityRefListId;

    @Column(name = "EntityRef_FullName")
    private String entityRefFullName;

    @ManyToOne
    @JoinColumn(name = "CustomerRef_ListID")
    private Customer customer;

    @Column(name = "CustomerRef_FullName")
    private String customerRefFullName;

    @Column(name = "ItemServiceRef_ListID")
    private String itemServiceRefListId;

    @Column(name = "ItemServiceRef_FullName")
    private String itemServiceRefFullName;

    @Column
    private String rate;

    @Column
    private String duration;

    @Column(name = "ClassRef_ListID")
    private String classRefListId;

    @Column(name = "ClassRef_FullName")
    private String classRefFullName;

    @Column(name = "PayrollItemWageRef_ListID")
    private String payrollItemWageRefListId;

    @Column(name = "PayrollItemWageRef_FullName")
    private String payrollItemWageRefFullName;

    @Column
    @Lob
    private String notes;

    @Column(name = "IsBillable")
    private String isBillable;

    @Column(name = "IsBilled")
    private String isBilled;

    @Column(name = "BillableStatus")
    private String billableStatus;
    
    @Column
    private String status;

    public String getTxnId() {
        return txnId;
    }

    public void setTxnId(String txnId) {
        this.txnId = txnId;
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

    public Integer getTxnNumber() {
        return txnNumber;
    }

    public void setTxnNumber(Integer txnNumber) {
        this.txnNumber = txnNumber;
    }

    public Date getTxnDate() {
        return txnDate;
    }

    public void setTxnDate(Date txnDate) {
        this.txnDate = txnDate;
    }

    public String getEntityRefListId() {
        return entityRefListId;
    }

    public void setEntityRefListId(String entityRefListId) {
        this.entityRefListId = entityRefListId;
    }

    public String getEntityRefFullName() {
        return entityRefFullName;
    }

    public void setEntityRefFullName(String entityRefFullName) {
        this.entityRefFullName = entityRefFullName;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCustomerRefFullName() {
        return customerRefFullName;
    }

    public void setCustomerRefFullName(String customerRefFullName) {
        this.customerRefFullName = customerRefFullName;
    }

    public String getItemServiceRefListId() {
        return itemServiceRefListId;
    }

    public void setItemServiceRefListId(String itemServiceRefListId) {
        this.itemServiceRefListId = itemServiceRefListId;
    }

    public String getItemServiceRefFullName() {
        return itemServiceRefFullName;
    }

    public void setItemServiceRefFullName(String itemServiceRefFullName) {
        this.itemServiceRefFullName = itemServiceRefFullName;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getClassRefListId() {
        return classRefListId;
    }

    public void setClassRefListId(String classRefListId) {
        this.classRefListId = classRefListId;
    }

    public String getClassRefFullName() {
        return classRefFullName;
    }

    public void setClassRefFullName(String classRefFullName) {
        this.classRefFullName = classRefFullName;
    }

    public String getPayrollItemWageRefListId() {
        return payrollItemWageRefListId;
    }

    public void setPayrollItemWageRefListId(String payrollItemWageRefListId) {
        this.payrollItemWageRefListId = payrollItemWageRefListId;
    }

    public String getPayrollItemWageRefFullName() {
        return payrollItemWageRefFullName;
    }

    public void setPayrollItemWageRefFullName(String payrollItemWageRefFullName) {
        this.payrollItemWageRefFullName = payrollItemWageRefFullName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getIsBillable() {
        return isBillable;
    }

    public void setIsBillable(String isBillable) {
        this.isBillable = isBillable;
    }

    public String getIsBilled() {
        return isBilled;
    }

    public void setIsBilled(String isBilled) {
        this.isBilled = isBilled;
    }

    public String getBillableStatus() {
        return billableStatus;
    }

    public void setBillableStatus(String billableStatus) {
        this.billableStatus = billableStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
