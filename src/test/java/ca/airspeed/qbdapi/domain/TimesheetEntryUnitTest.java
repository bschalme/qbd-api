package ca.airspeed.qbdapi.domain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

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
    void invalidTimesheetEntry() throws Exception {
        // Given:
        TimesheetEntry entry = TimesheetEntry.builder().build();

        // When:
        Set<ConstraintViolation<TimesheetEntry>> constraintViolations = validator.validate(entry);

        // Then:
        assertThat(constraintViolations, hasSize(1));
        ConstraintViolation<TimesheetEntry> violation = constraintViolations.iterator().next();
        assertThat(violation.getPropertyPath().toString(), is("associateId"));
        assertThat(violation.getMessage(), is("must not be blank"));
    }
}
