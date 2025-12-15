package ca.airspeed.qbdapi.adapter.in.web;

import static io.micronaut.http.HttpRequest.POST;
import static io.micronaut.http.HttpStatus.BAD_REQUEST;
import static io.micronaut.http.HttpStatus.CREATED;
import static io.micronaut.http.hateoas.Link.SELF;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import io.micronaut.http.client.HttpClient;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import org.junit.jupiter.api.Test;

import ca.airspeed.qbdapi.adapter.in.web.model.WebCreditCardCharge;
import ca.airspeed.qbdapi.adapter.in.web.resource.CreditCardChargeResponseResource;
import ca.airspeed.qbdapi.application.port.in.EnterCreditCardChargeUseCase;
import ca.airspeed.qbdapi.domain.CreditCardCharge;
import io.micronaut.core.value.OptionalMultiValues;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.http.hateoas.Link;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;

@MicronautTest
class CreditCardChargeControllerUnitTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Inject
    private EntityManager entityManager;

    @Inject
    private EnterCreditCardChargeUseCase mockEnterCreditCardChargeUseCase;

    @MockBean(EnterCreditCardChargeUseCase.class)
    EnterCreditCardChargeUseCase mockEnterCreditCardChargeUseCase() {
        return mock(EnterCreditCardChargeUseCase.class);
    }

    @Test
    void enterCreditCardCharge() throws Exception {
        // Given:
        WebCreditCardCharge charge = new WebCreditCardCharge();
        charge.setRefNumber("1234567890A");
        when(mockEnterCreditCardChargeUseCase.enterCreditCardCharge(isA(CreditCardCharge.class))).thenReturn(CreditCardCharge.builder()
                .id("ABC-123")
                .build());

        // When:
        HttpResponse<CreditCardChargeResponseResource> response = client.toBlocking()
                .exchange(POST("/qbd-api/credit-card-charges", charge).basicAuth("user", "password"), CreditCardChargeResponseResource.class);

        // Then:
        assertThat(response, notNullValue());
        assertThat(response.getStatus(), is(CREATED));
        Optional<CreditCardChargeResponseResource> bodyOptional = response.getBody();
        assertTrue(bodyOptional.isPresent(), "No body in the HTTP response;");
        CreditCardChargeResponseResource body = bodyOptional.get();
        OptionalMultiValues<Link> links = body.getLinks();
        Optional<List<Link>> selfOptional = links.get(SELF);
        assertTrue(selfOptional.isPresent(), "'self' link exists;");
        List<Link> selfLinks = selfOptional.get();
        assertThat(selfLinks, hasSize(greaterThan(0)));
        assertThat(selfLinks.get(0).getHref(), is("/qbd-api/credit-card-charges/ABC-123"));
    }

    @Test
    void refNumberTooLong_BadRequest() throws Exception {
        // Given:
        WebCreditCardCharge charge = new WebCreditCardCharge();
        charge.setRefNumber("1234567890AB");
        when(mockEnterCreditCardChargeUseCase.enterCreditCardCharge(isA(CreditCardCharge.class))).thenReturn(CreditCardCharge.builder()
                .id("ABC-123")
                .build());
        /* 
                */

        // When:
        HttpClientResponseException e = assertThrows(HttpClientResponseException.class, () -> client.toBlocking()
                .exchange(POST("/qbd-api/credit-card-charges", charge).basicAuth("user", "password"), CreditCardChargeResponseResource.class));

        // Then:
        HttpResponse<?> response = e.getResponse();
        assertThat(response, notNullValue());
        assertThat("HTTP Status Code;", response.getStatus(), is(BAD_REQUEST));
        /* 
        Optional<?> bodyOptional = response.getBody();
        assertTrue(bodyOptional.isPresent(), "No body in the HTTP response;");
        System.out.println(bodyOptional.get().toString());
        */
    }
}
