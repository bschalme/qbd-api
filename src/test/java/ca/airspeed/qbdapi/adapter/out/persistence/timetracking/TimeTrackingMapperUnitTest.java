package ca.airspeed.qbdapi.adapter.out.persistence.timetracking;

import static java.time.ZoneId.systemDefault;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.airspeed.qbdapi.adapter.out.persistence.customer.CustomerJpaEntity;
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
        TimesheetEntry timesheetEntry = timesheetEntry();

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
        Date expectedDate = Date.from(LocalDate.now().minusDays(1).atStartOfDay(systemDefault()).toInstant());
        assertThat(entity.getTxnDate(), is(expectedDate));
        assertThat(entity.getDuration(), is("PT1H30M"));
        assertThat(entity.getNotes(), is("0900-1030:Project ID:Task ID:Architecture Review with the team."));
        assertThat(entity.getBillableStatus(), is("Billable"));
        assertThat(entity.getIsBillable(), is("true"));
    }

    @Test
    void exactHours() throws Exception {
        // Given:
        TimesheetEntry timesheetEntry = timesheetEntry();
        timesheetEntry.setDuration(Duration.ofHours(2));

        // When:
        List<TimeTrackingJpaEntity> entities = mapper.mapListToJpaEntries(asList(timesheetEntry));

        // Then:
        assertThat(entities, hasSize(1));
        TimeTrackingJpaEntity entity = entities.get(0);
        assertThat(entity, notNullValue());
        assertThat(entity.getDuration(), is("PT2H0M"));
    }

    @Test
    void lessThanOneHour() throws Exception {
        // Given:
        TimesheetEntry timesheetEntry = timesheetEntry();
        timesheetEntry.setDuration(Duration.ofMinutes(30));

        // When:
        List<TimeTrackingJpaEntity> entities = mapper.mapListToJpaEntries(asList(timesheetEntry));

        // Then:
        assertThat(entities, hasSize(1));
        TimeTrackingJpaEntity entity = entities.get(0);
        assertThat(entity, notNullValue());
        assertThat(entity.getDuration(), is("PT0H30M"));
    }

    @Test
    void mapToDomainObject() throws Exception {
        // Given:
        LocalDate yesterday = LocalDate.now().minusDays(1);
        CustomerJpaEntity customer = new CustomerJpaEntity();
        customer.setListID("BBB-4567");
        TimeTrackingJpaEntity jpa = new TimeTrackingJpaEntity();
        jpa.setTxnId("ABC-123");
        jpa.setEntityRefListId("DEF-456");
        jpa.setCustomer(customer);
        jpa.setItemServiceRefListId("JKL=012");
        jpa.setTxnDate(Date.from(yesterday.atStartOfDay(systemDefault()).toInstant()));
        jpa.setDuration("PT1H30M");
        jpa.setNotes("0900-1030:Project ID:Task ID:Architecture Review with the team.");
        jpa.setBillableStatus("Billable");

        // When:
        TimesheetEntry result = mapper.mapToDomainObject(jpa);

        // Then:
        assertThat(result, notNullValue());
        assertThat(result.getId(), is("ABC-123"));
        assertThat(result.getAssociateId(), is("DEF-456"));
        assertThat(result.getJobId(), is("BBB-4567"));
        assertThat(result.getDateWorked(), is(yesterday));
        assertThat(result.getDuration(), is(Duration.ofMinutes(90)));
        assertThat(result.getNotes(), is("0900-1030:Project ID:Task ID:Architecture Review with the team."));
        assertThat(result.getBillableStatus(), is("Billable"));
    }

    private TimesheetEntry timesheetEntry() {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        ZonedDateTime yesterdayAt0900 = ZonedDateTime.now().minusDays(1).withHour(9).withMinute(0).withSecond(0);
        ZonedDateTime yesterdayAt1030 = ZonedDateTime.now().minusDays(1).withHour(10).withMinute(30).withSecond(0);
        return TimesheetEntry.builder()
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
    }
}
