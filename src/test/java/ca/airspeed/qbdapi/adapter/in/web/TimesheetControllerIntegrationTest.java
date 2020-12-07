package ca.airspeed.qbdapi.adapter.in.web;

import static io.micronaut.http.HttpRequest.POST;
import static io.micronaut.http.HttpStatus.CREATED;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ca.airspeed.qbdapi.adapter.in.web.model.WebTimesheetEntry;
import ca.airspeed.qbdapi.adapter.in.web.model.WebTimesheetEntryList;
import ca.airspeed.qbdapi.adapter.in.web.resource.WebTimesheetEntryListResponse;
import ca.airspeed.qbdapi.adapter.out.persistence.CustomerJpaEntity;
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
    private EntityManager entityManager;

    @Test
    @DisplayName("Enter a set of Timesheets")
    void testEnterTimesheets() throws Exception {
        // Given:
        CustomerJpaEntity def456 = new CustomerJpaEntity();
        def456.setListID("DEF-456");
        def456.setName("MegaCorp");
        entityManager.persist(def456);
        entityManager.getTransaction().commit();

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
        HttpResponse<WebTimesheetEntryListResponse> response = client.toBlocking()
                .exchange(POST("/qbd-api/timesheets", entryList), WebTimesheetEntryListResponse.class);

        // Then:
        System.out.println("*** Test class: response is a " + response);
        assertThat(response, notNullValue());
        assertThat(response.getStatus(), is(CREATED));
        Optional<WebTimesheetEntryListResponse> bodyOptional = response.getBody();
        assertTrue(bodyOptional.isPresent(), "No body in the HTTP response;");
        WebTimesheetEntryListResponse body = bodyOptional.get();
        assertThat(body.getSavedTimesheetEntries(), hasSize(entryList.getEntries().size()));
        WebTimesheetEntry responseEntry = entryList.getEntries().get(0);
    }

}
