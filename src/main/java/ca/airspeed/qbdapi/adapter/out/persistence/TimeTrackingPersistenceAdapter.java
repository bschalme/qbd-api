package ca.airspeed.qbdapi.adapter.out.persistence;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

import java.util.List;

import javax.inject.Singleton;

import ca.airspeed.qbdapi.application.port.out.SaveTimesheetPort;
import ca.airspeed.qbdapi.domain.TimesheetEntry;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
public class TimeTrackingPersistenceAdapter implements SaveTimesheetPort {

    private static final String ADD = "ADD";

    private final TimeTrackingJpaRepository repo;
    private final TimeTrackingMapper mapper;

    @Override
    public List<TimesheetEntry> addTimesheetEntries(List<TimesheetEntry> entries) {
        List<TimeTrackingJpaEntity> jpaEntities = mapper.mapListToJpaEntries(entries);
        int i = 0;
        for(TimeTrackingJpaEntity jpaEntity: jpaEntities) {
            jpaEntity.setStatus(ADD);
            String txnId = randomAlphanumeric(6,13);
            jpaEntity.setTxnId(txnId);
            entries.get(i).setId(txnId);
            i++;
        }
        repo.saveAll(jpaEntities);
        return entries;
    }

}
