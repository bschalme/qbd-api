package ca.airspeed.qbdapi.application.port.in;

import ca.airspeed.qbdapi.domain.TimesheetEntry;

public interface RetrieveTimesheetEntryUseCase {
    TimesheetEntry retrieveTimesheet(String id);
}
