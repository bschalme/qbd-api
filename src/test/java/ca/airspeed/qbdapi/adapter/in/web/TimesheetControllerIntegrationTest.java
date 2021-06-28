package ca.airspeed.qbdapi.adapter.in.web;

import static io.micronaut.http.HttpRequest.GET;
import static io.micronaut.http.HttpRequest.POST;
import static io.micronaut.http.HttpStatus.CREATED;
import static io.micronaut.http.HttpStatus.FORBIDDEN;
import static io.micronaut.http.HttpStatus.OK;
import static io.micronaut.http.HttpStatus.UNAUTHORIZED;
import static io.micronaut.http.hateoas.Link.SELF;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import ca.airspeed.qbdapi.adapter.in.model.InputTimesheetEntry;
import ca.airspeed.qbdapi.adapter.in.model.InputTimesheetEntryList;
import ca.airspeed.qbdapi.adapter.in.web.resource.WebTimesheetEntryListResponse;
import ca.airspeed.qbdapi.adapter.in.web.resource.WebTimesheetEntryResponseResource;
import ca.airspeed.qbdapi.adapter.out.persistence.customer.CustomerJpaEntity;
import ca.airspeed.qbdapi.application.port.in.RetrieveTimesheetEntryUseCase;
import ca.airspeed.qbdapi.application.port.in.SearchForTimesheetEntriesUseCase;
import ca.airspeed.qbdapi.domain.TimesheetEntry;
import io.micronaut.core.value.OptionalMultiValues;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.http.hateoas.Link;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;

@MicronautTest
class TimesheetControllerIntegrationTest {

    @Inject
    @Client("/")
    RxHttpClient client;

    @Inject
    private EntityManager entityManager;

    @Inject
    private RetrieveTimesheetEntryUseCase mockRetrieveTimesheetEntryUseCase;

    @Inject
    private SearchForTimesheetEntriesUseCase mockSearchForTimesheetEntriesUseCase;

    @MockBean(RetrieveTimesheetEntryUseCase.class)
    RetrieveTimesheetEntryUseCase mockRetrieveTimesheetEntryUseCase() {
        return mock(RetrieveTimesheetEntryUseCase.class);
    }

    @MockBean(SearchForTimesheetEntriesUseCase.class)
    SearchForTimesheetEntriesUseCase mockSearchForTimesheetEntriesUseCase() {
        return mock(SearchForTimesheetEntriesUseCase.class);
    }

    @Test
    @DisplayName("Enter a set of Timesheets")
    void testEnterTimesheets() throws Exception {
        // Given:
        CustomerJpaEntity def456 = new CustomerJpaEntity();
        def456.setListID("DEF-456");
        def456.setName("MegaCorp");
        entityManager.persist(def456);
        entityManager.getTransaction().commit();

        InputTimesheetEntry entry = new InputTimesheetEntry();
        entry.setAssociateId("ABC-123");
        entry.setJobId("DEF-456");
        entry.setServiceItemId("GHI-789");
        entry.setDateWorked(LocalDate.of(2020, 11, 10));
        entry.setStartDateTime(ZonedDateTime.of(2020, 11, 10, 8, 0, 0, 0, ZoneId.of("America/Winnipeg")));
        entry.setEndDateTime(ZonedDateTime.of(2020, 11, 10, 9, 30, 0, 0, ZoneId.of("America/Winnipeg")));
        entry.setDurationInMinutes(90);
        entry.setNotes("Hello World!");
        entry.setBillableStatus("Billable");
        InputTimesheetEntryList entryList = new InputTimesheetEntryList();
        entryList.setEntries(asList(entry));

        // When:
        HttpResponse<WebTimesheetEntryListResponse> response = client.toBlocking()
                .exchange(POST("/qbd-api/timesheets", entryList).basicAuth("user", "password"), WebTimesheetEntryListResponse.class);

        // Then:
        assertThat(response, notNullValue());
        assertThat(response.getStatus(), is(CREATED));
        Optional<WebTimesheetEntryListResponse> bodyOptional = response.getBody();
        assertTrue(bodyOptional.isPresent(), "No body in the HTTP response;");
        WebTimesheetEntryListResponse body = bodyOptional.get();
        assertThat(body.getSavedTimesheetEntries(), hasSize(entryList.getEntries().size()));
        InputTimesheetEntry responseEntry = entryList.getEntries().get(0);
    }

    @Test
    @DisplayName("An unauthenticated user tries to retrieve a Timesheet entry")
    void retrieveOneTimesheetUnauthenticated_fails() throws Exception {
        // When:
        Executable e = () -> client.toBlocking().exchange(
                GET("/qbd-api/timesheets/AAAA-1234"), WebTimesheetEntryResponseResource.class);

        // Then:
        HttpClientResponseException thrown = assertThrows(HttpClientResponseException.class, e);
        assertEquals(UNAUTHORIZED, thrown.getStatus());
    }

    @Test
    @DisplayName("A user without any permissions tries to retrieve a Timesheet entry")
    void retrieveOneTimesheetUnauthorized_fails() throws Exception {
        // When:
        Executable e = () -> client.toBlocking().exchange(
                GET("/qbd-api/timesheets/AAAA-1234").basicAuth("eswan", "rescueme"),
                WebTimesheetEntryResponseResource.class);

        // Then:
        HttpClientResponseException thrown = assertThrows(HttpClientResponseException.class, e);
        assertEquals(FORBIDDEN, thrown.getStatus());
    }

    @Test
    @DisplayName("A duly authorized user can retrieve a Timesheet entry")
    void retrieveOneTimesheetEntry_succeeds() throws Exception {
        // Given:
        when(mockRetrieveTimesheetEntryUseCase.retrieveTimesheet(isA(String.class))).thenReturn(TimesheetEntry.builder()
                .id("AAAA-1234")
                .associateId("ABC-123")
                .duration(Duration.ofMinutes(150))
                .notes("Hello World!")
                .build());

        // When:
        HttpResponse<WebTimesheetEntryResponseResource> response = client.exchange(
                GET("/qbd-api/timesheets/AAAA-1234").basicAuth("user", "password"),
                WebTimesheetEntryResponseResource.class).blockingFirst();

        // Then:
        assertThat(response, notNullValue());
        assertThat(response.getStatus(), is(OK));
        WebTimesheetEntryResponseResource body = response.body();
        assertThat("Response body;", body, notNullValue());
        assertThat("ID;", body.getId(), is("AAAA-1234"));
        assertThat("associateId;", body.getAssociateId(), is("ABC-123"));
        assertThat("durationInMinutes;", body.getDurationInMinutes(), is(150));
        assertThat("Notes;", body.getNotes(), is("Hello World!"));
        OptionalMultiValues<Link> links = body.getLinks();
        Optional<List<Link>> selfOptional = links.get(SELF);
        assertTrue(selfOptional.isPresent(), "Missing 'self' link;");
        List<Link> selfLinks = selfOptional.get();
        assertThat(selfLinks, hasSize(greaterThan(0)));
        assertThat("_self link;", selfLinks.get(0).getHref(), is("/qbd-api/timesheets/AAAA-1234"));
    }

    @Test
    @DisplayName("An unauthenticated user tries to search for an Associate's timesheet entries in a date range")
    void searchByDatesAndAssociateIdUnauthenticated_fails() throws Exception {
        // When:
        Executable e = () -> client.toBlocking().exchange(
                GET("/qbd-api/timesheets/?fromDate=2020-06-01&toDate=2020-06-30&associateId=ABC-123"), WebTimesheetEntryListResponse.class);

        // Then:
        HttpClientResponseException thrown = assertThrows(HttpClientResponseException.class, e);
        assertEquals(UNAUTHORIZED, thrown.getStatus());
    }

    @Test
    @DisplayName("An unauthorized user tries to search for an Associate's timesheet entries in a date range")
    void searchByDatesAndAssociateIdUnauthorized_fails() throws Exception {
        // When:
        Executable e = () -> client.toBlocking().exchange(
                GET("/qbd-api/timesheets/?fromDate=2020-06-01&toDate=2020-06-30&associateId=ABC-123").basicAuth("eswan",
                        "rescueme"),
                WebTimesheetEntryListResponse.class);

        // Then:
        HttpClientResponseException thrown = assertThrows(HttpClientResponseException.class, e);
        assertEquals(FORBIDDEN, thrown.getStatus());
    }

    @Test
    @DisplayName("An authorized user can search for an Associate's timesheet entries for a given date range")
    void searchByDatesAndAssociateId_succeeds() throws Exception {
        // Given:
        when(mockSearchForTimesheetEntriesUseCase.findByTxnDatesBetweenAndAssociateId(isA(LocalDate.class),
                isA(LocalDate.class), isA(String.class)))
                .thenReturn(twoTimesheetEntries());

        // When:
        HttpResponse<WebTimesheetEntryListResponse> response = client.exchange(
                GET("/qbd-api/timesheets/?fromDate=2020-06-01&toDate=2020-06-30&associateId=ABC-123")
                .basicAuth("user", "password"),
                WebTimesheetEntryListResponse.class).blockingFirst();

        // Then:
        assertThat(response, notNullValue());
        assertThat(response.getStatus(), is(OK));
        WebTimesheetEntryListResponse body = response.body();
        assertThat("Response body;", body, notNullValue());
        List<WebTimesheetEntryResponseResource> timesheetEntryResources = body.getSavedTimesheetEntries();
        assertThat("Timesheet entry resources;", timesheetEntryResources, hasSize(2));
        WebTimesheetEntryResponseResource resource = timesheetEntryResources.get(0);
        assertThat(resource.getId(), is("ABC-123"));
        OptionalMultiValues<Link> links = resource.getLinks();
        Optional<List<Link>> selfOptional = links.get(SELF);
        assertTrue(selfOptional.isPresent(), "Missing 'self' link;");
        List<Link> selfLinks = selfOptional.get();
        assertThat(selfLinks, hasSize(greaterThan(0)));
        assertThat(selfLinks.get(0).getHref(), is("/qbd-api/timesheets/ABC-123"));
    }

    private List<TimesheetEntry> twoTimesheetEntries() {
        return asList(
                TimesheetEntry.builder()
                .id("ABC-123")
                .build(),
                TimesheetEntry.builder()
                .id("DEF-456")
                .build());
    }

    private List<TimesheetEntry> threeTimesheetEntries() {
        return asList(
                TimesheetEntry.builder()
                .id("ABC-123")
                .build(),
                TimesheetEntry.builder()
                .id("DEF-456")
                .build(),
                TimesheetEntry.builder()
                .id("GHI-789")
                .build());
    }
}
