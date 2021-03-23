package ca.airspeed.qbdapi.application.service;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ca.airspeed.qbdapi.application.port.out.TimesheetPort;
import ca.airspeed.qbdapi.domain.TimesheetEntry;

@ExtendWith(MockitoExtension.class)
class TimesheetServiceUnitTest {

    @InjectMocks
    private TimesheetService service;

    @Mock
    private TimesheetPort mockPort;
    
    @Test
    void testEnterTimesheet() throws Exception {
        // Given:
        TimesheetEntry entry = TimesheetEntry.builder()
                .build();
        List<TimesheetEntry> timesheets = asList(entry);

        // When:
        service.enterTimesheet(timesheets);

        // Then:
        verify(mockPort).addTimesheetEntries(timesheets);
    }

    @Test
    void retrieveOneTimesheetEntry() throws Exception {
        // Given:
        when(mockPort.findByTimesheetEntryId(isA(String.class))).thenReturn(TimesheetEntry.builder()
                .id("ABC-123")
                .notes("Hello World!")
                .build());

        // When:
        TimesheetEntry result = service.retrieveTimesheet("ABC-123");

        // Then:
        assertThat("Resulting TimesheetEntry;", result, notNullValue());
        assertThat("ID;", result.getId(), is("ABC-123"));
        assertThat("Notes;", result.getNotes(), is("Hello World!"));
    }

    @Test
    void findByTxnDatesBetween() throws Exception {
        // Given:
        LocalDate fromDate = LocalDate.now().minusMonths(1).withDayOfMonth(1);
        LocalDate toDate = LocalDate.now().minusMonths(1).withDayOfMonth(28);
        when(mockPort.findByTxnDatesBetween(fromDate, toDate)).thenReturn(threeTimesheetEntries());

        // When:
        List<TimesheetEntry> results = service.findByTxnDatesBetween(fromDate, toDate);

        // Then:
        assertThat("Timesheet entries returned;", results, hasSize(3));
    }

    @Test
    void findByTxnDatesBetweenAndAssociateId() throws Exception {
        // Given:
        LocalDate fromDate = LocalDate.now().minusMonths(1).withDayOfMonth(1);
        LocalDate toDate = LocalDate.now().minusMonths(1).withDayOfMonth(28);
        String associateId = "ABC-123";
        when(mockPort.findByTxnDatesBetweenAndAssociateId(fromDate, toDate, associateId))
                .thenReturn(twoTimesheetEntries());

        // When:
        List<TimesheetEntry> results = service.findByTxnDatesBetweenAndAssociateId(fromDate, toDate, associateId);

        // Then:
        assertThat("Timesheet entries returned;", results, hasSize(2));
    }

    private List<TimesheetEntry> twoTimesheetEntries() {
        return asList(
                TimesheetEntry.builder()
                .build(),
                TimesheetEntry.builder()
                .build());
    }

    private List<TimesheetEntry> threeTimesheetEntries() {
        return asList(
                TimesheetEntry.builder()
                .build(),
                TimesheetEntry.builder()
                .build(),
                TimesheetEntry.builder()
                .build());
    }
}
