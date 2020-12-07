package ca.airspeed.qbdapi.application.port.out;

import java.util.List;

import ca.airspeed.qbdapi.domain.TimesheetEntry;

public interface SaveTimesheetPort {
    List<TimesheetEntry> addTimesheetEntries(List<TimesheetEntry> entries);
}
