package ca.airspeed.qbdapi.adapter.out.persistence.timetracking;

import static javax.persistence.ConstraintMode.NO_CONSTRAINT;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ca.airspeed.qbdapi.adapter.out.persistence.customer.CustomerJpaEntity;
import io.micronaut.core.annotation.Introspected;
import lombok.Data;

@Entity
@Table(name = "timetracking")
@Data
@Introspected
public class TimeTrackingJpaEntity {

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
    @JoinColumn(name = "CustomerRef_ListID",
            referencedColumnName = "ListID",
            insertable = true, 
            updatable = true, 
            foreignKey = @javax.persistence.ForeignKey(value = NO_CONSTRAINT))
    private CustomerJpaEntity customer;

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
}
