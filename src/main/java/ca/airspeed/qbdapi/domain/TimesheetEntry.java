package ca.airspeed.qbdapi.domain;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZonedDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

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
    @Size(min = 1, max = 36)
    private String associateId;

    @Pattern(regexp = "[A-Za-z0-9-]+")
    @Size(min = 1, max = 36)
    private String jobId;

    @NotBlank
    @Pattern(regexp = "[A-Za-z0-9-]+")
    @Size(min = 1, max = 36)
    private String serviceItemId;

    private LocalDate dateWorked;
    private ZonedDateTime startDateTime;
    private ZonedDateTime endDateTime;
    private Duration duration;
    private String notes;
    private String billableStatus;
    
}
