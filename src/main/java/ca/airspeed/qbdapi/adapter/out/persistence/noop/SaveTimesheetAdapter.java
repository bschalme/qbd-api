package ca.airspeed.qbdapi.adapter.out.persistence.noop;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ca.airspeed.qbdapi.application.port.out.TimesheetPort;
import ca.airspeed.qbdapi.domain.TimesheetEntry;

public class SaveTimesheetAdapter implements TimesheetPort {

    @Override
    public List<TimesheetEntry> addTimesheetEntries(List<TimesheetEntry> entries) {
        return entries;
    }

    @Override
    public TimesheetEntry findByTimesheetEntryId(String id) {
        return TimesheetEntry.builder()
                .build();
    }

    @Override
    public List<TimesheetEntry> findByTxnDatesBetweenAndAssociateId(LocalDate fromDate, LocalDate toDate,
            String associateId) {
        return new ArrayList<TimesheetEntry>();
    }

    @Override
    public List<TimesheetEntry> findByTxnDatesBetween(LocalDate fromDate, LocalDate toDate) {
        return new ArrayList<TimesheetEntry>();
    }

}
