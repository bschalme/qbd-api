package ca.airspeed.qbdapi.adapter.out.persistence;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ca.airspeed.qbdapi.domain.TimesheetEntry;

@ExtendWith(MockitoExtension.class)
class TimeTrackingPersistenceAdapterUnitTest {

    @Mock
    private TimeTrackingJpaRepository mockRepo;

    @Mock
    private TimeTrackingMapper mockMapper;

    @Captor
    private ArgumentCaptor<List<TimeTrackingJpaEntity>> captor;

    @InjectMocks
    private TimeTrackingPersistenceAdapter adapter;

    @Test
    void addTimesheetEntries() throws Exception {
        // Given:
        List<TimesheetEntry> timesheetEntries = makeTimesheetEntries();
        List<TimeTrackingJpaEntity> timeTrackingEntities = makeTimeTrackingEntries();
        when(mockMapper.mapListToJpaEntries(timesheetEntries)).thenReturn(timeTrackingEntities);

        // When:
        List<TimesheetEntry> results = adapter.addTimesheetEntries(timesheetEntries);

        // Then:
        verify(mockRepo).saveAll(captor.capture());
        assertThat("TxnID;", captor.getValue().get(0).getTxnId(), not(emptyOrNullString()));
        assertThat(captor.getValue().get(0).getStatus(), is("ADD"));
        assertThat(results, hasSize(1));
        assertThat(results.get(0).getId(), not(emptyOrNullString()));
    }

    @Test
    void retrieveOneTimesheetEntry() throws Exception {
        // Given:
        String txnId = "ABC-123";
        TimeTrackingJpaEntity timeTrackingJpaEntity = new TimeTrackingJpaEntity();
        timeTrackingJpaEntity.setTxnId(txnId);
        when(mockRepo.findById(isA(String.class))).thenReturn(Optional.of(timeTrackingJpaEntity));
        when(mockMapper.mapToDomainObject(isA(TimeTrackingJpaEntity.class))).thenReturn(makeTimesheetEntries().get(0));

        // When:
        TimesheetEntry result = adapter.findByTimesheetEntryId(txnId);

        // Then:
        assertThat(result, notNullValue());
        assertThat(result.getId(), is(txnId));
        assertThat(result.getJobId(), is("GHI-789"));
        assertThat(result.getNotes(), is("Project ID:Task ID:Architecture Review with the team."));
    }

    private List<TimesheetEntry> makeTimesheetEntries() {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        ZonedDateTime yesterdayAt0900 = ZonedDateTime.now().minusDays(1).withHour(9).withMinute(0).withSecond(0);
        ZonedDateTime yesterdayAt1030 = ZonedDateTime.now().minusDays(1).withHour(10).withMinute(30).withSecond(0);
        TimesheetEntry timesheetEntry = TimesheetEntry.builder()
                .id("ABC-123")
                .associateId("DEF-456")
                .jobId("GHI-789")
                .serviceItemId("JKL-012")
                .dateWorked(yesterday)
                .startDateTime(yesterdayAt0900)
                .endDateTime(yesterdayAt1030)
                .duration(Duration.ofMinutes(90))
                .notes("Project ID:Task ID:Architecture Review with the team.")
                .billableStatus("Billable")
                .build();

        return asList(timesheetEntry);
    }

    private List<TimeTrackingJpaEntity> makeTimeTrackingEntries() {
        return asList(new TimeTrackingJpaEntity());
    }
}
