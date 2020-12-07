package ca.airspeed.qbdapi.adapter.out.persistence.noop;

import java.util.List;

import ca.airspeed.qbdapi.application.port.out.SaveTimesheetPort;
import ca.airspeed.qbdapi.domain.TimesheetEntry;

public class SaveTimesheetAdapter implements SaveTimesheetPort {

    @Override
    public List<TimesheetEntry> addTimesheetEntries(List<TimesheetEntry> entries) {
        return entries;
    }

}
