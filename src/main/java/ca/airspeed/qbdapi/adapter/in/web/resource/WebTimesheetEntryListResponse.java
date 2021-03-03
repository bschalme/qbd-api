package ca.airspeed.qbdapi.adapter.in.web.resource;

import java.util.List;

import io.micronaut.core.annotation.Introspected;
import lombok.Data;

@Introspected
@Data
public class WebTimesheetEntryListResponse {
    private List<WebTimesheetEntryResponseResource> savedTimesheetEntries;

    public WebTimesheetEntryListResponse() {

    }

    public WebTimesheetEntryListResponse(List<WebTimesheetEntryResponseResource> savedTimesheetEntries) {
        this.savedTimesheetEntries = savedTimesheetEntries;
    }
}
