package ca.airspeed.qbdapi.adapter.in.web;

import static io.micronaut.http.HttpResponse.created;
import static io.micronaut.http.HttpResponse.ok;
import static io.micronaut.http.hateoas.Link.SELF;
import static java.lang.String.format;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ca.airspeed.qbdapi.adapter.in.model.InputTimesheetEntry;
import ca.airspeed.qbdapi.adapter.in.model.InputTimesheetEntryList;
import ca.airspeed.qbdapi.adapter.in.web.resource.WebTimesheetEntryListResponse;
import ca.airspeed.qbdapi.adapter.in.web.resource.WebTimesheetEntryMapper;
import ca.airspeed.qbdapi.adapter.in.web.resource.WebTimesheetEntryResponseResource;
import ca.airspeed.qbdapi.application.port.in.EnterTimesheetUseCase;
import ca.airspeed.qbdapi.application.port.in.RetrieveTimesheetEntryUseCase;
import ca.airspeed.qbdapi.application.port.in.SearchForTimesheetEntriesUseCase;
import ca.airspeed.qbdapi.domain.TimesheetEntry;
import io.micronaut.context.annotation.Value;
import io.micronaut.core.convert.format.Format;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.authentication.Authentication;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller("/timesheets")
@RequiredArgsConstructor
@Slf4j
@Secured("MyGroup")
public class TimesheetController {

    private final EnterTimesheetUseCase enterTimesheetUseCase;
    private final RetrieveTimesheetEntryUseCase retrieveTimesheetEntryUseCase;
    private final SearchForTimesheetEntriesUseCase searchForTimesheetEntriesUseCase;
    
    @Value("${micronaut.server.context-path:}")
    private String serverContextPath;

    /**
     * Create a new Timesheet.
     * 
     * @param timesheetList
     * @return
     */
    @ApiResponse(responseCode = "201", description = "Successfully created.")
    @ApiResponse(responseCode = "500", description = "Something horrible happened on our end.")
    @Post
    @ExecuteOn(TaskExecutors.IO)
    public HttpResponse<WebTimesheetEntryListResponse> enterTimesheets(@Body InputTimesheetEntryList timesheetList) {
        List<InputTimesheetEntry> webEntries = timesheetList.getEntries();
        List<TimesheetEntry> domainTimesheetEntries = new ArrayList<>();
        for (InputTimesheetEntry webEntry: webEntries) {
            domainTimesheetEntries.add(TimesheetEntry.builder()
                    .associateId(webEntry.getAssociateId())
                    .billableStatus(webEntry.getBillableStatus())
                    .dateWorked(webEntry.getDateWorked())
                    .startDateTime(webEntry.getStartDateTime())
                    .endDateTime(webEntry.getEndDateTime())
                    .duration(Duration.ofMinutes((webEntry.getDurationInMinutes())))
                    .jobId(webEntry.getJobId())
                    .serviceItemId(webEntry.getServiceItemId())
                    .notes(webEntry.getNotes())
                    .build());
        }
        List<TimesheetEntry> results = enterTimesheetUseCase.enterTimesheet(domainTimesheetEntries);
        List<WebTimesheetEntryResponseResource> savedTimesheets = new ArrayList<>();
        for (TimesheetEntry result: results) {
            WebTimesheetEntryResponseResource resultItem = WebTimesheetEntryResponseResource.builder()
                    .build();
            resultItem.link(SELF, format("%s/timesheets/%s", serverContextPath, result.getId()));
            savedTimesheets.add(resultItem);
        }
        WebTimesheetEntryListResponse response = new WebTimesheetEntryListResponse(savedTimesheets);
        int entryCount = response.getSavedTimesheetEntries().size();
        log.info("Created {} timeheet {}.", entryCount, entryCount == 1 ? "entry" : "entries");
        return created(response);
    }

    /**
     * Retrieve one Timesheet Entry using its id.
     * 
     * @param id
     * @param authn
     * @return
     */
    @ApiResponse(responseCode = "200", description = "Success.")
    @ApiResponse(responseCode = "500", description = "Something horrible happened on our end.")
    @Get("/{id}")
    @ExecuteOn(TaskExecutors.IO)
    public HttpResponse<WebTimesheetEntryResponseResource> findOneTimesheetEntry(String id, Authentication authn) {
        TimesheetEntry entry = retrieveTimesheetEntryUseCase.retrieveTimesheet(id);
        WebTimesheetEntryResponseResource response = WebTimesheetEntryMapper.INSTANCE
                .domainObjectToWebTimesheetEntry(entry);
        response.link(SELF, format("%s/timesheets/%s", serverContextPath, id));
        return ok(response);
    }

    /**
     * Search for Timesheet Entries.
     * 
     * @param fromDate
     * @param toDate
     * @param associateId
     * @return
     */
    @ApiResponse(responseCode = "200", description = "Success.")
    @ApiResponse(responseCode = "500", description = "Something horrible happened on our end.")
    @Get("/")
    @ExecuteOn(TaskExecutors.IO)
    public HttpResponse<WebTimesheetEntryListResponse> findByTxnDatesBetweenAndAssociateId(
            @Format("yyyy-MM-dd") @QueryValue LocalDate fromDate,
            @Format("yyyy-MM-dd") @QueryValue LocalDate toDate,
            @QueryValue String associateId) {
        List<TimesheetEntry> timesheetEntries = searchForTimesheetEntriesUseCase
                .findByTxnDatesBetweenAndAssociateId(fromDate, toDate, associateId);
        List<WebTimesheetEntryResponseResource> responseResources = WebTimesheetEntryMapper.INSTANCE
                .domainObjectsToWebTimesheetEntryResponseResources(timesheetEntries);
        for (WebTimesheetEntryResponseResource responseResource: responseResources) {
            responseResource.link(SELF, format("%s/timesheets/%s", serverContextPath, responseResource.getId()));
        }
        return ok(new WebTimesheetEntryListResponse(responseResources));
    }
}
