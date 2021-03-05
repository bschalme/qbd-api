package ca.airspeed.qbdapi.adapter.in.web;

import static io.micronaut.http.hateoas.Link.SELF;
import static java.lang.String.format;

import java.util.ArrayList;
import java.util.List;

import ca.airspeed.qbdapi.adapter.in.web.resource.SearchForServiceItemResponseResource;
import ca.airspeed.qbdapi.application.port.in.RetrieveServiceItemUseCase;
import ca.airspeed.qbdapi.domain.ServiceItem;
import io.micronaut.context.annotation.Value;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.hateoas.JsonError;
import io.micronaut.http.hateoas.Link;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import io.micronaut.security.annotation.Secured;
import io.micronaut.http.annotation.Error;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller("/service-items")
@RequiredArgsConstructor
@Slf4j
@Secured("MyGroup")
public class ServiceItemController {

    private final RetrieveServiceItemUseCase retrieveServiceItem;

    @Value("${micronaut.server.context-path:}")
    private String serverContextPath;

    @Get("/{serviceItemId}")
    @ExecuteOn(TaskExecutors.IO)
    public SearchForServiceItemResponseResource findOneServiceItem(String serviceItemId) {
        log.info(format("Received a request for findOneServiceItem() on '%s'.", serviceItemId));
        ServiceItem serviceItem = retrieveServiceItem.retrieveServiceItem(serviceItemId);
        if (serviceItem == null) {
            return null;
        }
        SearchForServiceItemResponseResource result = SearchForServiceItemResponseResource.builder()
                .id(serviceItem.getId())
                .name(serviceItem.getName())
                .fullName(serviceItem.getFullName())
                .description(serviceItem.getDescription())
                .price(serviceItem.getPrice())
                .build();
        result.link(SELF, format("%s/service-items/%s", serverContextPath, result.getId()));
        return result;
    }

    /**
     * Search for a Service Item using the first few characters of its Full
     * Name.
     * 
     * @param fullName
     *            the first few characters of the Full Name.
     * @return a list of Service Items meeting the search criteria.
     */
    @Get("/")
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

    @Error(status = HttpStatus.NOT_FOUND)
    public HttpResponse<JsonError> notFound(@SuppressWarnings("rawtypes") HttpRequest request) {
        JsonError error = new JsonError("Service Item Not Found")
                .link(SELF, Link.of(request.getUri()));

        return HttpResponse.<JsonError>notFound().body(error);
    }
}
