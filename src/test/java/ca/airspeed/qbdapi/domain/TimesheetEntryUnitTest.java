package ca.airspeed.qbdapi.domain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import java.time.LocalDate;
import java.util.Set;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.micronaut.validation.validator.Validator;

@MicronautTest
class TimesheetEntryUnitTest {

    @Inject
    Validator validator;

    @Test
    void happyPath() throws Exception {
        // Given:
        TimesheetEntry entry = validTimesheetEntry();

        // When:
        Set<ConstraintViolation<TimesheetEntry>> constraintViolations = validator.validate(entry);

        // Then:
        assertThat("Validation errors;", constraintViolations, hasSize(0));
        
    }

    @ParameterizedTest
    @CsvSource({
        ",must not be blank",
        "%$78,must match \"[A-Za-z0-9-]+\"",
        "ABCDEF-123456-GH,size must be between 1 and 15"
    })
    void associateId(String associateId, String message) throws Exception {
        // Given:
        TimesheetEntry entry = validTimesheetEntry();
        entry.setAssociateId(associateId);

        // When:
        Set<ConstraintViolation<TimesheetEntry>> constraintViolations = validator.validate(entry);

        // Then:
        assertThat("Validation errors;", constraintViolations, hasSize(1));
        ConstraintViolation<TimesheetEntry> violation = constraintViolations.iterator().next();
        assertThat(violation.getPropertyPath().toString(), is("associateId"));
        assertThat(violation.getMessage(), is(message));
    }

    @ParameterizedTest
    @CsvSource({
        "&*(GTRS@$34,must match \"[A-Za-z0-9-]+\"",
        "ABCDEF-123456-GH,size must be between 1 and 15"
    })
    void jobId(String jobId, String message) throws Exception {
        // Given:
        TimesheetEntry entry = validTimesheetEntry();
        entry.setJobId(jobId);

        // When:
        Set<ConstraintViolation<TimesheetEntry>> constraintViolations = validator.validate(entry);

        // Then:
        assertThat("Validation errors;", constraintViolations, hasSize(1));
        ConstraintViolation<TimesheetEntry> violation = constraintViolations.iterator().next();
        assertThat(violation.getPropertyPath().toString(), is("jobId"));
        assertThat(violation.getMessage(), is(message));
    }

    @ParameterizedTest
    @CsvSource({
        ",must not be blank",
        "GHI*(<>?4568,must match \"[A-Za-z0-9-]+\"",
        "GHIJKLM-12345689,size must be between 1 and 15"
    })
    void serviceItemId(String serviceItemId, String message) throws Exception {
        // Given:
        TimesheetEntry entry = validTimesheetEntry();
        entry.setServiceItemId(serviceItemId);

        // When:
        Set<ConstraintViolation<TimesheetEntry>> constraintViolations = validator.validate(entry);

        // Then:
        assertThat("Validation errors;", constraintViolations, hasSize(1));
        ConstraintViolation<TimesheetEntry> violation = constraintViolations.iterator().next();
        assertThat(violation.getPropertyPath().toString(), is("serviceItemId"));
        assertThat(violation.getMessage(), is(message));
    }

    private TimesheetEntry validTimesheetEntry() {
        return TimesheetEntry.builder()
                .associateId("ABC-123")
                .jobId("DEF-456")
                .serviceItemId("GHIJKLM-1234568")
                .dateWorked(LocalDate.now())
                .build();
    }

}
