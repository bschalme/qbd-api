package ca.airspeed.qbdapi.domain;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZonedDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.micronaut.core.annotation.Introspected;
import lombok.Builder;
import lombok.Data;

@Data
@Introspected
@Builder
public class TimesheetEntry {

    private String id;

    @NotBlank
    @Pattern(regexp = "[A-Za-z0-9-]+")
    @Size(min = 1, max = 15)
    private String associateId;

    @Pattern(regexp = "[A-Za-z0-9-]+")
    @Size(min = 1, max = 15)
    private String jobId;

    @NotBlank
    @Pattern(regexp = "[A-Za-z0-9-]+")
    @Size(min = 1, max = 15)
    private String serviceItemId;

    private LocalDate dateWorked;
    private ZonedDateTime startDateTime;
    private ZonedDateTime endDateTime;
    private Duration duration;
    private String notes;
    
}
