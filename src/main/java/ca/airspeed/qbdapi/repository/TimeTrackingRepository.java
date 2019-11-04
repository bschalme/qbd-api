package ca.airspeed.qbdapi.repository;

import java.util.Date;

import ca.airspeed.qbdapi.domain.Customer;
import ca.airspeed.qbdapi.domain.TimeTracking;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.repository.PageableRepository;

@Repository
public interface TimeTrackingRepository extends PageableRepository<TimeTracking, String> {

    Page<TimeTracking> findByTxnDate(Date txnDate, Pageable pageable);

    Page<TimeTracking> findByTxnDateBetween(Date fromDate, Date toDate, Pageable pageable);

    Page<TimeTracking> findByCustomerAndBillableStatus(Customer customer, String billableStatus, Pageable pageable);
}
