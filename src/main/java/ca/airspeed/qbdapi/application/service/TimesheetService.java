package ca.airspeed.qbdapi.application.service;

import java.time.LocalDate;
import java.util.List;

import jakarta.inject.Singleton;
import jakarta.validation.Valid;

import ca.airspeed.qbdapi.application.port.in.EnterTimesheetUseCase;
import ca.airspeed.qbdapi.application.port.in.RetrieveTimesheetEntryUseCase;
import ca.airspeed.qbdapi.application.port.in.SearchForTimesheetEntriesUseCase;
import ca.airspeed.qbdapi.application.port.out.TimesheetPort;
import ca.airspeed.qbdapi.domain.TimesheetEntry;
import io.micronaut.validation.Validated;

@Singleton
@Validated
public class TimesheetService implements EnterTimesheetUseCase, RetrieveTimesheetEntryUseCase, SearchForTimesheetEntriesUseCase {
    private TimesheetPort port;

    public TimesheetService(TimesheetPort port) {
        super();
        this.port = port;
    }

    @Override
    public List<TimesheetEntry> enterTimesheet(@Valid List<TimesheetEntry> timesheetEntries) {
        for(TimesheetEntry entry: timesheetEntries) {
            
        }
        return port.addTimesheetEntries(timesheetEntries);

    }

    @Override
    public TimesheetEntry retrieveTimesheet(String id) {
        return port.findByTimesheetEntryId(id);
    }

    @Override
    public List<TimesheetEntry> findByTxnDatesBetweenAndAssociateId(LocalDate fromDate, LocalDate toDate,
            String associateId) {
        return port.findByTxnDatesBetweenAndAssociateId(fromDate, toDate, associateId);
    }

    @Override
    public List<TimesheetEntry> findByTxnDatesBetween(LocalDate fromDate, LocalDate toDate) {
        return port.findByTxnDatesBetween(fromDate, toDate);
    }

}
