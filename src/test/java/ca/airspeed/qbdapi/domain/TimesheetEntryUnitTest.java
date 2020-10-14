package ca.airspeed.qbdapi.domain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import java.util.Set;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;

import org.junit.jupiter.api.Test;

import io.micronaut.test.annotation.MicronautTest;
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
        final Set<ConstraintViolation<TimesheetEntry>> constraintViolations = validator.validate(entry);

        // Then:
        assertThat(constraintViolations, hasSize(1));
    }
}
