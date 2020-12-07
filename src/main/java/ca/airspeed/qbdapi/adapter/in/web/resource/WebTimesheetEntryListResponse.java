package ca.airspeed.qbdapi.adapter.in.web.resource;

import java.util.List;

import io.micronaut.core.annotation.Introspected;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Introspected
@Data
@RequiredArgsConstructor
public class WebTimesheetEntryListResponse {
    private final List<WebTimesheetEntryResponseResource> savedTimesheetEntries;
}
