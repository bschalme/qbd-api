package ca.airspeed.qbdapi.application.service;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ca.airspeed.qbdapi.application.port.out.SaveTimesheetPort;
import ca.airspeed.qbdapi.domain.TimesheetEntry;

@ExtendWith(MockitoExtension.class)
class TimesheetServiceUnitTest {

    @InjectMocks
    private TimesheetService service;

    @Mock
    private SaveTimesheetPort mockRepo;
    
    @Test
    void testEnterTimesheet() throws Exception {
        // Given:
        TimesheetEntry entry = TimesheetEntry.builder()
                .build();
        List<TimesheetEntry> timesheets = asList(entry);

        // When:
        service.enterTimesheet(timesheets);

        // Then:
        verify(mockRepo).addTimesheetEntries(timesheets);
    }

}
