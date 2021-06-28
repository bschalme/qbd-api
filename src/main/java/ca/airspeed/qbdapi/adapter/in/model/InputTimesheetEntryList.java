package ca.airspeed.qbdapi.adapter.in.model;

import java.util.ArrayList;
import java.util.List;

import ca.airspeed.qbdapi.adapter.in.model.InputTimesheetEntry;
import io.micronaut.core.annotation.Introspected;
import lombok.Data;

@Data
@Introspected
public class InputTimesheetEntryList {
    private List<InputTimesheetEntry> entries;

    public InputTimesheetEntryList() {
        entries = new ArrayList<>();
    }

}
