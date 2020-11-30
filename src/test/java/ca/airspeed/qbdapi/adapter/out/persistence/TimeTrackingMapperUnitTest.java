package ca.airspeed.qbdapi.adapter.out.persistence;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

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
    void testMapTopJpaEntry() throws Exception {
        // Given:
        TimesheetEntry timesheetEntry = TimesheetEntry.builder()
                .id("ABC-123")
                .associateId("DEF-456")
                .jobId("GHI-789")
                .serviceItemId("JKL-012")
                .build();

        // When:
        TimeTrackingJpaEntity entity = mapper.mapTopJpaEntry(timesheetEntry);

        // Then:
        assertThat(entity, notNullValue());
        assertThat(entity.getTxnId(), is("ABC-123"));
        assertThat(entity.getEntityRefListId(), is("DEF-456"));
        assertThat(entity.getCustomer(), notNullValue());
        assertThat(entity.getCustomer().getListID(), is("GHI-789"));
        assertThat(entity.getItemServiceRefListId(), is("JKL-012"));
    }

}
