package ca.airspeed.qbdapi.adapter.out.persistence.timetracking;

import static jakarta.persistence.ConstraintMode.NO_CONSTRAINT;

import java.util.Date;

import ca.airspeed.qbdapi.adapter.out.persistence.customer.CustomerJpaEntity;
import io.micronaut.core.annotation.Introspected;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
            foreignKey = @jakarta.persistence.ForeignKey(value = NO_CONSTRAINT))
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

    @Column(columnDefinition = "LONGTEXT")
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
