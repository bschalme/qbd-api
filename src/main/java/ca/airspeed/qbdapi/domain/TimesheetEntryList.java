package ca.airspeed.qbdapi.domain;

import java.util.ArrayList;
import java.util.List;

import io.micronaut.core.annotation.Introspected;
import lombok.Data;

@Data
@Introspected
public class TimesheetEntryList {
    private List<TimesheetEntry> entries;

    public TimesheetEntryList() {
        entries = new ArrayList<>();
    }

    public TimesheetEntryList(List<TimesheetEntry> entries) {
        super();
        this.entries = entries;
    }

}
