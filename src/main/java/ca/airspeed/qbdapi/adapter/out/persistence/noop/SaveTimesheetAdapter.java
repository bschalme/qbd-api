package ca.airspeed.qbdapi.adapter.out.persistence.noop;

import java.util.List;

import javax.inject.Singleton;

import ca.airspeed.qbdapi.application.port.out.SaveTimesheetPort;
import ca.airspeed.qbdapi.domain.TimesheetEntry;

@Singleton
public class SaveTimesheetAdapter implements SaveTimesheetPort {

    @Override
    public List<TimesheetEntry> saveTimesheetEntries(List<TimesheetEntry> entries) {
        return entries;
    }

}
