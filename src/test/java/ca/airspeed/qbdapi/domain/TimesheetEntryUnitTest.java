package ca.airspeed.qbdapi.domain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import java.time.LocalDate;
import java.util.Set;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;

import org.junit.jupiter.api.Test;

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

    @Test
    void associateId_blank() throws Exception {
        // Given:
        TimesheetEntry entry = validTimesheetEntry();
        entry.setAssociateId(null);

        // When:
        Set<ConstraintViolation<TimesheetEntry>> constraintViolations = validator.validate(entry);

        // Then:
        assertThat("Validation errors;", constraintViolations, hasSize(1));
        ConstraintViolation<TimesheetEntry> violation = constraintViolations.iterator().next();
        assertThat(violation.getPropertyPath().toString(), is("associateId"));
        assertThat(violation.getMessage(), is("must not be blank"));
    }

    @Test
    void associateId_invalidFormat() throws Exception {
        // Given:
        TimesheetEntry entry = validTimesheetEntry();
        entry.setAssociateId("%$78");

        // When:
        Set<ConstraintViolation<TimesheetEntry>> constraintViolations = validator.validate(entry);

        // Then:
        assertThat("Validation errors;", constraintViolations, hasSize(1));
        ConstraintViolation<TimesheetEntry> violation = constraintViolations.iterator().next();
        assertThat(violation.getPropertyPath().toString(), is("associateId"));
        assertThat(violation.getMessage(), is("must match \"[A-Za-z0-9-]+\""));
    }

    @Test
    void associateId_tooLong() throws Exception {
        // Given:
        TimesheetEntry entry = validTimesheetEntry();
        entry.setAssociateId("ABCDEF-123456-GH");

        // When:
        Set<ConstraintViolation<TimesheetEntry>> constraintViolations = validator.validate(entry);

        // Then:
        assertThat("Validation errors;", constraintViolations, hasSize(1));
        ConstraintViolation<TimesheetEntry> violation = constraintViolations.iterator().next();
        assertThat(violation.getPropertyPath().toString(), is("associateId"));
        assertThat(violation.getMessage(), is("size must be between 1 and 15"));
    }

    @Test
    void jobId_invalidFormat() throws Exception {
        // Given:
        TimesheetEntry entry = validTimesheetEntry();
        entry.setJobId("&*(GTRS@$34");

        // When:
        Set<ConstraintViolation<TimesheetEntry>> constraintViolations = validator.validate(entry);

        // Then:
        assertThat("Validation errors;", constraintViolations, hasSize(1));
        ConstraintViolation<TimesheetEntry> violation = constraintViolations.iterator().next();
        assertThat(violation.getPropertyPath().toString(), is("jobId"));
        assertThat(violation.getMessage(), is("must match \"[A-Za-z0-9-]+\""));
    }

    @Test
    void jobId_tooLong() throws Exception {
        // Given:
        TimesheetEntry entry = validTimesheetEntry();
        entry.setJobId("ABCDEF-123456-GH");

        // When:
        Set<ConstraintViolation<TimesheetEntry>> constraintViolations = validator.validate(entry);

        // Then:
        assertThat("Validation errors;", constraintViolations, hasSize(1));
        ConstraintViolation<TimesheetEntry> violation = constraintViolations.iterator().next();
        assertThat(violation.getPropertyPath().toString(), is("jobId"));
        assertThat(violation.getMessage(), is("size must be between 1 and 15"));
    }

    @Test
    void serviceItemId_blank() throws Exception {
        // Given:
        TimesheetEntry entry = validTimesheetEntry();
        entry.setServiceItemId(null);

        // When:
        Set<ConstraintViolation<TimesheetEntry>> constraintViolations = validator.validate(entry);

        // Then:
        assertThat("Validation errors;", constraintViolations, hasSize(1));
        ConstraintViolation<TimesheetEntry> violation = constraintViolations.iterator().next();
        assertThat(violation.getPropertyPath().toString(), is("serviceItemId"));
        assertThat(violation.getMessage(), is("must not be blank"));
    }

    @Test
    void serviceItemId_invalidFormat() throws Exception {
        // Given:
        TimesheetEntry entry = validTimesheetEntry();
        entry.setServiceItemId("GHI*(<>?4568");

        // When:
        Set<ConstraintViolation<TimesheetEntry>> constraintViolations = validator.validate(entry);

        // Then:
        assertThat("Validation errors;", constraintViolations, hasSize(1));
        ConstraintViolation<TimesheetEntry> violation = constraintViolations.iterator().next();
        assertThat(violation.getPropertyPath().toString(), is("serviceItemId"));
        assertThat(violation.getMessage(), is("must match \"[A-Za-z0-9-]+\""));
    }

    @Test
    void serviceItemId_tooLong() throws Exception {
        // Given:
        TimesheetEntry entry = validTimesheetEntry();
        entry.setServiceItemId("GHIJKLM-12345689");

        // When:
        Set<ConstraintViolation<TimesheetEntry>> constraintViolations = validator.validate(entry);

        // Then:
        assertThat("Validation errors;", constraintViolations, hasSize(1));
        ConstraintViolation<TimesheetEntry> violation = constraintViolations.iterator().next();
        assertThat(violation.getPropertyPath().toString(), is("serviceItemId"));
        assertThat(violation.getMessage(), is("size must be between 1 and 15"));
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
