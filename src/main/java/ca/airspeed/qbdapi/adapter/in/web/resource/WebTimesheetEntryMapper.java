package ca.airspeed.qbdapi.adapter.in.web.resource;

import static java.time.temporal.ChronoUnit.SECONDS;

import java.time.Duration;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import ca.airspeed.qbdapi.domain.TimesheetEntry;

@Mapper
public interface WebTimesheetEntryMapper {

    WebTimesheetEntryMapper INSTANCE = Mappers.getMapper(WebTimesheetEntryMapper.class);

    List<WebTimesheetEntryResponseResource> domainObjectsToWebTimesheetEntryResponseResources(List<TimesheetEntry> timesheetEntries);

    @Mapping(source = "duration", target = "durationInMinutes")
    WebTimesheetEntryResponseResource domainObjectToWebTimesheetEntry(TimesheetEntry timesheetEntry);

    default Integer map(Duration value) {
        if (value == null) {
            return null;
        }
        return (int) value.get(SECONDS) / 60;
    }
}
