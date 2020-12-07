package ca.airspeed.qbdapi.application.service;

import java.util.List;

import javax.inject.Singleton;
import javax.validation.Valid;

import ca.airspeed.qbdapi.application.port.in.EnterTimesheetUseCase;
import ca.airspeed.qbdapi.application.port.out.SaveTimesheetPort;
import ca.airspeed.qbdapi.domain.TimesheetEntry;
import io.micronaut.validation.Validated;

@Singleton
@Validated
public class TimesheetService implements EnterTimesheetUseCase {
    private SaveTimesheetPort port;

    public TimesheetService(SaveTimesheetPort port) {
        super();
        this.port = port;
    }

    @Override
    public List<TimesheetEntry> enterTimesheet(@Valid List<TimesheetEntry> timesheetEntries) {
        for(TimesheetEntry entry: timesheetEntries) {
            
        }
        return port.addTimesheetEntries(timesheetEntries);

    }

}
