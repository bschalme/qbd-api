package ca.airspeed.qbdapi.adapter.in.web;

import static io.micronaut.http.HttpRequest.POST;
import static io.micronaut.http.HttpStatus.CREATED;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import ca.airspeed.qbdapi.adapter.in.web.model.WebTimesheetEntry;
import ca.airspeed.qbdapi.adapter.in.web.model.WebTimesheetEntryList;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;

@MicronautTest
class TimesheetControllerIntegrationTest {

    @Inject
    @Client("/")
    RxHttpClient client;

    @Inject
    private ObjectMapper mapper;

    @Test
    void testEnterTimesheets() throws Exception {
        // Given:
        WebTimesheetEntry entry = new WebTimesheetEntry();
        entry.setAssociateId("ABC-123");
        entry.setJobId("DEF-456");
        entry.setServiceItemId("GHI-789");
        entry.setDateWorked(LocalDate.of(2020, 11, 10));
        entry.setStartDateTime(ZonedDateTime.of(2020, 11, 10, 8, 0, 0, 0, ZoneId.of("America/Winnipeg")));
        entry.setEndDateTime(ZonedDateTime.of(2020, 11, 10, 9, 30, 0, 0, ZoneId.of("America/Winnipeg")));
        entry.setDurationInMinutes(90);
        entry.setNotes("Hello World!");
        entry.setBillableStatus("Billable");
        WebTimesheetEntryList entryList = new WebTimesheetEntryList();
        entryList.setEntries(asList(entry));

        // When:
        HttpResponse<WebTimesheetEntryList> response = client.toBlocking()
                .exchange(POST("/qbd-api/timesheets", entryList));

        // Then:
        assertThat(response, notNullValue());
        assertThat(response.getStatus(), is(CREATED));
    }

}
