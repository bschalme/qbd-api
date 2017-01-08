package ca.airspeed.qbdapi.repository;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;

import ca.airspeed.qbdapi.domain.TimeTracking;

@RepositoryRestResource(collectionResourceRel = "timeTrackingEntries", path = "timeTrackingEntries")
public interface TimeTrackingRepository extends PagingAndSortingRepository<TimeTracking, String> {

    Page<TimeTracking> findByTxnDate(@DateTimeFormat(pattern = "yyyy-MM-dd") @Param("txnDate") Date txnDate,
            Pageable pageable);
}
