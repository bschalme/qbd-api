package ca.airspeed.qbdapi.adapter.in.web;

import static io.micronaut.http.HttpRequest.GET;
import static io.micronaut.http.HttpStatus.FORBIDDEN;
import static io.micronaut.http.HttpStatus.OK;
import static io.micronaut.http.HttpStatus.UNAUTHORIZED;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import ca.airspeed.qbdapi.adapter.in.web.resource.CustomerResource;
import ca.airspeed.qbdapi.application.port.in.RetrieveCustomerUseCase;
import ca.airspeed.qbdapi.application.port.in.SearchForCustomerUseCase;
import ca.airspeed.qbdapi.application.service.RetrieveCustomerService;
import ca.airspeed.qbdapi.domain.Customer;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;

@MicronautTest
class CustomerControllerIntegrationTest {

    @Inject
    RetrieveCustomerUseCase mockRetrieveService;

    @Inject
    SearchForCustomerUseCase mockSearchService;

    @Inject
    @Client("/")
    RxHttpClient client; 

    @MockBean(RetrieveCustomerService.class)
    RetrieveCustomerUseCase mockRetrieveService() {
        return mock(RetrieveCustomerUseCase.class);
    }

    @MockBean(SearchForCustomerUseCase.class)
    SearchForCustomerUseCase mockSearchService() {
        return mock(SearchForCustomerUseCase.class);
    }

    @Inject
    private ObjectMapper mapper;

    @Test
    void unauthenticatedUser_fails() throws Exception {
        // When:
        Executable e = () -> client.toBlocking().exchange(GET("/qbd-api/customers/?fullName=Mega"), List.class);

        // Then:
        HttpClientResponseException chucked = assertThrows(HttpClientResponseException.class, e);
        assertEquals(UNAUTHORIZED, chucked.getStatus());
    }

    @Test
    void unauthorizedUser_fails() throws Exception {
        // When:
        Executable e = () -> client.toBlocking()
                .exchange(GET("/qbd-api/customers/1")
                        .basicAuth("eswan", "rescueme"),
                CustomerResource.class);

        // Then:
        HttpClientResponseException chucked = assertThrows(HttpClientResponseException.class, e);
        assertEquals(FORBIDDEN, chucked.getStatus());
    }

    @Test
    void findOneCustomer() throws Exception {
        // Given:
        String one = "1";
        when(mockRetrieveService.retrieveCustomer(eq(one))).thenReturn(megaCorp());

        // When:
        String body = client.toBlocking().retrieve(GET("/qbd-api/customers/1").basicAuth("user", "password"));

        // Then:
        assertNotNull(body, "HTTP Response body cannot be null.");
        JsonNode root = mapper.readTree(body);
        assertEquals("1", root.at("/id").asText());
        assertEquals("MegaCorp Inc", root.at("/name").asText());
        assertEquals("/qbd-api/customers/1", root.at("/_links/self/href").asText(), "The self link");
    }

    @Test
    void searchByFullName() throws Exception {
        // Given:
        String mega = "Mega";
        when(mockSearchService.findByFullName(eq(mega))).thenReturn(asList(megaCorp()));

        // When:
        @SuppressWarnings("rawtypes")
        HttpResponse<List> response = client
                .exchange(GET("/qbd-api/customers/?fullName=Mega").basicAuth("user", "password"), List.class)
                .blockingFirst();

        // Then:
        assertThat(response, notNullValue());
        assertThat(response.getStatus(), is(OK));
        @SuppressWarnings("unchecked")
        List<Map<String, Object>> body = response.body();
        assertThat("Null body;", body, notNullValue());
        assertThat(body, hasSize(1));
        Map<String, Object> customer = body.get(0);
        assertThat(customer.get("name"), is("MegaCorp Inc"));
    }

    private Customer megaCorp() {
        return Customer.builder()
                .id("1")
                .name("MegaCorp Inc")
                .build();
    }
}
