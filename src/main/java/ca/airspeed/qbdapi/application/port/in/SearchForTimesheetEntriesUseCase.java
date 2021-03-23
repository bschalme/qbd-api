package ca.airspeed.qbdapi.application.port.in;

import java.time.LocalDate;
import java.util.List;

import ca.airspeed.qbdapi.domain.TimesheetEntry;

public interface SearchForTimesheetEntriesUseCase {
    List<TimesheetEntry> findByTxnDatesBetweenAndAssociateId(LocalDate fromDate, LocalDate toDate,
            String associateId);

    List<TimesheetEntry> findByTxnDatesBetween(LocalDate fromDate, LocalDate toDate);
}
