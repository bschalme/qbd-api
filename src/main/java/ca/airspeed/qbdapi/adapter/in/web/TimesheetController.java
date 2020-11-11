package ca.airspeed.qbdapi.adapter.in.web;

import static io.micronaut.http.HttpResponse.created;

import ca.airspeed.qbdapi.adapter.in.web.model.WebTimesheetEntryList;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import io.micronaut.security.annotation.Secured;
import lombok.extern.slf4j.Slf4j;

@Controller("/timesheets")
@Slf4j
public class TimesheetController {

    @Secured("isAnonymous()")
    @Post
    @ExecuteOn(TaskExecutors.IO)
    public HttpResponse<WebTimesheetEntryList> enterTimesheets(WebTimesheetEntryList timesheetList) {
        int entryCount = timesheetList.getEntries().size();
        log.info("Created {} timeheet {}.", entryCount, entryCount == 1 ? "entry" : "entries");
        return created(timesheetList);
    }
}
