package ca.airspeed.qbdapi.adapter.in.web.model;

import java.util.ArrayList;
import java.util.List;

import io.micronaut.core.annotation.Introspected;
import lombok.Data;

@Data
@Introspected
public class WebTimesheetEntryList {
    private List<WebTimesheetEntry> entries;

    public WebTimesheetEntryList() {
        entries = new ArrayList<>();
    }

}
