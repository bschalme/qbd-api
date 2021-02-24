package ca.airspeed.qbdapi.adapter.in.web;

import static io.micronaut.http.hateoas.Link.SELF;
import static java.lang.String.format;

import java.util.ArrayList;
import java.util.List;

import ca.airspeed.qbdapi.adapter.in.web.resource.SearchForServiceItemResponseResource;
import ca.airspeed.qbdapi.application.port.in.RetrieveServiceItemUseCase;
import ca.airspeed.qbdapi.domain.ServiceItem;
import io.micronaut.context.annotation.Value;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import io.micronaut.security.annotation.Secured;
import lombok.RequiredArgsConstructor;

@Controller("/service-items")
@RequiredArgsConstructor
public class ServiceItemController {

    private final RetrieveServiceItemUseCase retrieveServiceItem;

    @Value("${micronaut.server.context-path:}")
    private String serverContextPath;

    /**
     * Search for a Service Item using the first few characters of its Full
     * Name.
     * 
     * @param fullName
     *            the first few characters of the Full Name.
     * @return a list of Service Items meeting the search criteria.
     */
    @Secured("isAnonymous()")
    @Get("/search/fullNameStartingWith")
    @ExecuteOn(TaskExecutors.IO)
    public List<SearchForServiceItemResponseResource> searchByFullNameStartingWith(@QueryValue String fullName) {
        List<ServiceItem> data = retrieveServiceItem.findByFullName(fullName);
        List<SearchForServiceItemResponseResource> results = new ArrayList<>();
        if (data == null) {
            return results;
        }
        for (ServiceItem serviceItem: data) {
            SearchForServiceItemResponseResource result = SearchForServiceItemResponseResource.builder()
                    .fullName(serviceItem.getFullName())
                    .id(serviceItem.getId())
                    .name(serviceItem.getName())
                    .description(serviceItem.getDescription())
                    .price(serviceItem.getPrice())
                    .build();
            result.link(SELF, format("%s/service-items/%s", serverContextPath, result.getId()));
            results.add(result);
        }
        return results;
    }
}
