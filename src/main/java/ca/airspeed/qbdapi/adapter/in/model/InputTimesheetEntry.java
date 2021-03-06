package ca.airspeed.qbdapi.adapter.in.model;

import java.time.LocalDate;
import java.time.ZonedDateTime;

import io.micronaut.core.annotation.Introspected;
import lombok.Data;

@Data
@Introspected
public class InputTimesheetEntry {
    private String associateId;
    private String jobId;
    private String serviceItemId;
    private LocalDate dateWorked;
    private ZonedDateTime startDateTime;
    private ZonedDateTime endDateTime;
    private int durationInMinutes;
    private String notes;
    private String billableStatus;
}
