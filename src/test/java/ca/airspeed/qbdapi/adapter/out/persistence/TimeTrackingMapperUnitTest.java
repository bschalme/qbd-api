package ca.airspeed.qbdapi.adapter.out.persistence;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZonedDateTime;

import static java.time.ZoneId.systemDefault;
import static java.util.Arrays.asList;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.airspeed.qbdapi.domain.TimesheetEntry;

class TimeTrackingMapperUnitTest {

    private TimeTrackingMapper mapper;

    @BeforeEach
    protected void setUp() throws Exception {
        mapper = new TimeTrackingMapper();
    }

    @Test
    void mapListToJpaEntries() throws Exception {
        // Given:
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

        // When:
        List<TimeTrackingJpaEntity> entities = mapper.mapListToJpaEntries(asList(timesheetEntry));

        // Then:
        assertThat(entities, hasSize(1));
        TimeTrackingJpaEntity entity = entities.get(0);
        assertThat(entity, notNullValue());
        assertThat(entity.getTxnId(), is("ABC-123"));
        assertThat(entity.getEntityRefListId(), is("DEF-456"));
        assertThat(entity.getCustomer(), notNullValue());
        assertThat(entity.getCustomer().getListID(), is("GHI-789"));
        assertThat(entity.getItemServiceRefListId(), is("JKL-012"));
        Date expectedDate = Date.from(yesterday.atStartOfDay(systemDefault()).toInstant());
        assertThat(entity.getTxnDate(), is(expectedDate));
        assertThat(entity.getDuration(), is("PT1H30M"));
        assertThat(entity.getNotes(), is("0900-1030:Project ID:Task ID:Architecture Review with the team."));
        assertThat(entity.getBillableStatus(), is("Billable"));
        assertThat(entity.getIsBillable(), is("true"));
    }
}