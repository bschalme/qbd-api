package ca.airspeed.qbdapi.adapter.in.web.resource;

import java.time.LocalDate;
import java.time.ZonedDateTime;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.hateoas.AbstractResource;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Introspected
@Data
@EqualsAndHashCode(callSuper=false)
@Builder
public class WebTimesheetEntryResponseResource extends AbstractResource<WebTimesheetEntryResponseResource> {

    private String id;
    private String associateId;
    private String jobId;
    private String serviceItemId;
    private LocalDate dateWorked;
    private ZonedDateTime startDateTime;
    private ZonedDateTime endDateTime;
    private Integer durationInMinutes;
    private String notes;
    private String billableStatus;
}
