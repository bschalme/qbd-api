package ca.airspeed.qbdapi.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ca.airspeed.qbdapi.domain.TimeTracking;

@RepositoryRestResource(collectionResourceRel = "timeTrackingEntries", path = "timeTrackingEntries")
public interface TimeTrackingRepository extends PagingAndSortingRepository<TimeTracking, String> {

}
