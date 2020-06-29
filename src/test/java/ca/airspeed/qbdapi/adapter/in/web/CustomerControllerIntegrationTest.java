package ca.airspeed.qbdapi.adapter.in.web;

import static io.micronaut.http.HttpRequest.GET;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import ca.airspeed.qbdapi.application.port.in.RetrieveCustomerUseCase;
import ca.airspeed.qbdapi.application.service.RetrieveCustomerService;
import ca.airspeed.qbdapi.domain.Customer;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import io.micronaut.test.annotation.MockBean;

@MicronautTest
class CustomerControllerIntegrationTest {

    @Inject
    RetrieveCustomerUseCase mockService;

    @Inject
    @Client("/")
    RxHttpClient client; 

    @MockBean(RetrieveCustomerService.class)
    RetrieveCustomerUseCase mockService() {
        return mock(RetrieveCustomerUseCase.class);
    }

    @Inject
    private ObjectMapper mapper;

    @Test
    void findOneCustomer() throws Exception {
        // Given:
        String one = "1";
        when(mockService.retrieveCustomer(eq(one))).thenReturn(megaCorp());

        // When:
        String body = client.toBlocking().retrieve(GET("/qbd-api/customers/1"));

        // Then:
        assertNotNull(body, "HTTP Response body cannot be null.");
        JsonNode root = mapper.readTree(body);
        assertEquals("1", root.at("/id").asText());
        assertEquals("MegaCorp Inc", root.at("/name").asText());
        assertEquals("/customers/1", root.at("/_links/self/href").asText(), "The self link");
    }

    private Customer megaCorp() {
        return Customer.builder()
                .id("1")
                .name("MegaCorp Inc")
                .build();
    }
}
