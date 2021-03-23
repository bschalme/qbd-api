package ca.airspeed.qbdapi.application.port.out;

import java.time.LocalDate;
import java.util.List;

import ca.airspeed.qbdapi.domain.TimesheetEntry;

public interface TimesheetPort {
    List<TimesheetEntry> addTimesheetEntries(List<TimesheetEntry> entries);

    TimesheetEntry findByTimesheetEntryId(String id);

    List<TimesheetEntry> findByTxnDatesBetweenAndAssociateId(LocalDate fromDate, LocalDate toDate, String associateId);

    List<TimesheetEntry> findByTxnDatesBetween(LocalDate fromDate, LocalDate toDate);
}
