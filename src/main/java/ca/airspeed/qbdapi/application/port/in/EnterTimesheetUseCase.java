package ca.airspeed.qbdapi.application.port.in;

import java.util.List;

import ca.airspeed.qbdapi.domain.TimesheetEntry;

public interface EnterTimesheetUseCase {
    
    public List<TimesheetEntry> enterTimesheet(List<TimesheetEntry> timesheetEntries);
}
