package ca.airspeed.qbdapi.domain;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZonedDateTime;

import javax.validation.constraints.NotBlank;

import io.micronaut.core.annotation.Introspected;
import lombok.Builder;
import lombok.Data;

@Data
@Introspected
@Builder
public class TimesheetEntry {

    private String id;
    @NotBlank
    private String associateId;
    private String jobId;
    private String serviceItemId;
    private LocalDate dateWorked;
    private ZonedDateTime startDateTime;
    private ZonedDateTime endDateTime;
    private Duration duration;
    private String notes;
    
}
