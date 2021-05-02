package ca.airspeed.qbdapi.adapter.in.web;

import static io.micronaut.http.HttpRequest.GET;
import static io.micronaut.http.HttpStatus.OK;
import static io.micronaut.http.hateoas.Link.SELF;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import ca.airspeed.qbdapi.adapter.in.web.resource.WebInvoiceResponseResource;
import ca.airspeed.qbdapi.application.port.in.RetrieveInvoiceUseCase;
import ca.airspeed.qbdapi.domain.Invoice;
import io.micronaut.core.value.OptionalMultiValues;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.hateoas.Link;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;

@MicronautTest
class InvoiceControllerIntegrationTest {

    @Inject
    @Client("/")
    RxHttpClient client;

    @Inject
    private EntityManager entityManager;

    @Inject
    private RetrieveInvoiceUseCase mockRetrieveInvoiceUseCase;

    @MockBean(RetrieveInvoiceUseCase.class)
    RetrieveInvoiceUseCase mockRetrieveInvoiceUseCase() {
        return mock(RetrieveInvoiceUseCase.class);
    }

    @Inject
    private ObjectMapper mapper;

    @Test
    void testFindById() throws Exception {
        // Given:
        when(mockRetrieveInvoiceUseCase.retrieveInvoice(eq("ABC-123"))).thenReturn(Invoice.builder()
                .id("ABC-123")
                .invoiceNumber("406")
                .build());

        // When:
        HttpResponse<WebInvoiceResponseResource> response = client
                .exchange(GET("/qbd-api/invoices/ABC-123").basicAuth("user", "password"), WebInvoiceResponseResource.class)
                .blockingFirst();

        // Then:
        assertThat(response, notNullValue());
        assertThat(response.getStatus(), is(OK));
        WebInvoiceResponseResource body = response.body();
        assertThat("Null body;", body, notNullValue());
        assertThat("Invoice ID;", body.getId(), is("ABC-123"));
        assertThat("Invoice number;", body.getInvoiceNumber(), is("406"));

        OptionalMultiValues<Link> links = body.getLinks();
        Optional<List<Link>> selfOptional = links.get(SELF);
        assertTrue(selfOptional.isPresent(), "'self' link exists;");
        List<Link> selfLinks = selfOptional.get();
        assertThat(selfLinks, hasSize(greaterThan(0)));
        assertThat(selfLinks.get(0).getHref(), is("/qbd-api/invoices/ABC-123"));
    }

}
