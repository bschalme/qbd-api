package ca.airspeed.qbdapi.application.service;

import java.util.List;

import javax.inject.Singleton;

import ca.airspeed.qbdapi.application.port.in.EnterTimesheetUseCase;
import ca.airspeed.qbdapi.domain.TimesheetEntry;

@Singleton
public class TimesheetService implements EnterTimesheetUseCase {

    @Override
    public void enterTimesheet(List<TimesheetEntry> timesheetEntries) {
        // TODO Auto-generated method stub

    }

}
