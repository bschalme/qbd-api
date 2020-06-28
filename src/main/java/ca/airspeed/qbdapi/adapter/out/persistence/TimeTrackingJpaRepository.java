package ca.airspeed.qbdapi.adapter.out.persistence;

import java.util.Date;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.repository.PageableRepository;

@Repository
public interface TimeTrackingJpaRepository extends PageableRepository<TimeTrackingJpaEntity, String> {

    Page<TimeTrackingJpaEntity> findByTxnDate(Date txnDate, Pageable pageable);

    Page<TimeTrackingJpaEntity> findByTxnDateBetween(Date fromDate, Date toDate, Pageable pageable);

    Page<TimeTrackingJpaEntity> findByCustomerAndBillableStatus(CustomerJpaEntity customer, String billableStatus, Pageable pageable);
}
