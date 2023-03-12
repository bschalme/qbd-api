package ca.airspeed.qbdapi.adapter.in.web;

import static io.micronaut.http.HttpRequest.GET;
import static io.micronaut.http.HttpStatus.OK;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.micronaut.core.type.Argument;
import io.micronaut.http.client.HttpClient;
import jakarta.inject.Inject;

import org.junit.jupiter.api.Test;

import ca.airspeed.qbdapi.adapter.in.web.resource.SearchForServiceItemResponseResource;
import ca.airspeed.qbdapi.application.port.in.RetrieveServiceItemUseCase;
import ca.airspeed.qbdapi.application.service.ServiceItemService;
import ca.airspeed.qbdapi.domain.ServiceItem;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.uri.UriBuilder;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;

@MicronautTest
class ServiceItemControllerIntegrationTest {

    @Inject
    RetrieveServiceItemUseCase mockRetrieveServiceItemService;

    @Inject
    @Client("/")
    HttpClient client;

    @MockBean(ServiceItemService.class)
    RetrieveServiceItemUseCase mockRetrieveServiceItemService() {
        return mock(RetrieveServiceItemUseCase.class);
    }

    @Test
    void findServiceItem() throws Exception {
        // Given:
        String sd100Id = "ABC-123";
        when(mockRetrieveServiceItemService.retrieveServiceItem(eq(sd100Id))).thenReturn(sd100());

        // When:
        Map<String, ? super Object> parms = new HashMap<>();
        parms.put("id", sd100Id);
        String url = UriBuilder.of("/qbd-api/service-items/{id}").expand(parms).toString();
        HttpResponse<SearchForServiceItemResponseResource> response = client.toBlocking()
                .exchange(GET(url).basicAuth("user", "password"), Argument.of(SearchForServiceItemResponseResource.class));
//        String body = client.toBlocking().retrieve(GET(url));

        // Then:
        assertThat(response, notNullValue());
        assertThat(response.getStatus(), is(OK));
        SearchForServiceItemResponseResource serviceItem = response.body();
//        SearchForServiceItemResponseResource serviceItem = mapper.readValue(body,
//                SearchForServiceItemResponseResource.class);
        assertThat("Null body;", serviceItem, notNullValue());
        assertThat(serviceItem.getId(), is("ABC-123"));
        assertThat(serviceItem.getFullName(), is("Software Development:SD100"));
        assertThat(serviceItem.getDescription(), is("Software Development (hours)"));
        assertThat(serviceItem.getPrice(), is(BigDecimal.valueOf(10000, 2)));
    }

    @Test
    void searchByFullNameStartingWith() throws Exception {
        // Given:
        String sd100 = "Software Development:SD100";
        when(mockRetrieveServiceItemService.findByFullName(eq(sd100))).thenReturn(asList(sd100()));

        // When:
        Map<String, ? super Object> parms = new HashMap<>();
        parms.put("fullName", sd100);
        String url = UriBuilder.of("/qbd-api/service-items/?fullName={fullName}").expand(parms).toString();
        @SuppressWarnings("rawtypes")
        HttpResponse<List<SearchForServiceItemResponseResource>> response = client.toBlocking()
                .exchange(GET(url).basicAuth("user", "password"), Argument.listOf(SearchForServiceItemResponseResource.class));

        // Then:
        assertThat(response, notNullValue());
        assertThat(response.getStatus(), is(OK));
        @SuppressWarnings("unchecked")
        List<SearchForServiceItemResponseResource> body = response.body();
        assertThat("Null body;", body, notNullValue());
        assertThat(body, hasSize(1));
        SearchForServiceItemResponseResource serviceItem = body.get(0);
        assertThat(serviceItem.getId(), is("ABC-123"));
        assertThat(serviceItem.getFullName(), is(sd100));
        assertThat(serviceItem.getDescription(), is("Software Development (hours)"));
        assertThat("Price;", serviceItem.getPrice(), is(BigDecimal.valueOf(10000, 2)));
    }

    private ServiceItem sd100() {
        return ServiceItem.builder()
                .id("ABC-123")
                .fullName("Software Development:SD100")
                .description("Software Development (hours)")
                .price(BigDecimal.valueOf(10000, 2))
                .build();
    }
}
