package ca.airspeed.qbdapi.adapter.in.web;

import static io.micronaut.http.HttpHeaders.LOCATION;
import static io.micronaut.http.HttpRequest.GET;
import static io.micronaut.http.HttpStatus.MOVED_PERMANENTLY;
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

import java.util.Currency;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import ca.airspeed.qbdapi.adapter.in.web.resource.CustomerResource;
import ca.airspeed.qbdapi.adapter.in.web.resource.WebInvoiceListResponse;
import ca.airspeed.qbdapi.adapter.in.web.resource.WebInvoiceResponseResource;
import ca.airspeed.qbdapi.application.port.in.RetrieveInvoiceUseCase;
import ca.airspeed.qbdapi.application.port.in.SearchForInvoiceUseCase;
import ca.airspeed.qbdapi.domain.Customer;
import ca.airspeed.qbdapi.domain.Invoice;
import io.micronaut.core.type.Argument;
import io.micronaut.core.value.OptionalMultiValues;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.hateoas.Link;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@MicronautTest
@Slf4j
class InvoiceControllerIntegrationTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Inject
    private EntityManager entityManager;

    @Inject
    private RetrieveInvoiceUseCase mockRetrieveInvoiceUseCase;

    @Inject
    private SearchForInvoiceUseCase mockSearchForInvoiceUseCase;

    @MockBean(RetrieveInvoiceUseCase.class)
    RetrieveInvoiceUseCase mockRetrieveInvoiceUseCase() {
        return mock(RetrieveInvoiceUseCase.class);
    }

    @MockBean(SearchForInvoiceUseCase.class)
    SearchForInvoiceUseCase mockSearchForInvoiceUseCase() {
        return mock(SearchForInvoiceUseCase.class);
    }

    @Inject
    private ObjectMapper mapper;

    @Test
    void testFindById() throws Exception {
        // Given:
        when(mockRetrieveInvoiceUseCase.retrieveInvoice(eq("ABC-123"))).thenReturn(Invoice.builder()
                .id("ABC-123")
                .invoiceNumber("406")
                .customer(Customer.builder()
                        .id("DEF-456")
                        .fullName("East India Company")
                        .build())
                .build());

        // When:
        HttpResponse<WebInvoiceResponseResource> response = client.toBlocking()
                .exchange(GET("/qbd-api/invoices/ABC-123").basicAuth("user", "password"), Argument.of(WebInvoiceResponseResource.class));

        // Then:
        assertThat(response, notNullValue());
        assertThat(response.getStatus(), is(OK));
        WebInvoiceResponseResource body = response.body();
        assertThat("Null body;", body, notNullValue());
        assertThat("Invoice ID;", body.getId(), is("ABC-123"));
        assertThat("Invoice number;", body.getInvoiceNumber(), is("406"));
        CustomerResource customer = body.getCustomer();
        assertThat("Customer;", customer, notNullValue());

        OptionalMultiValues<Link> links = body.getLinks();
        Optional<List<Link>> selfOptional = links.get(SELF);
        assertTrue(selfOptional.isPresent(), "'self' link exists;");
        List<Link> selfLinks = selfOptional.get();
        assertThat(selfLinks, hasSize(greaterThan(0)));
        assertThat(selfLinks.get(0).getHref(), is("/qbd-api/invoices/ABC-123"));

        Optional<List<Link>> customerOptional = links.get("customer");
        assertTrue(customerOptional.isPresent(), "'customer' link exists;");
        List<Link> customerLinks = customerOptional.get();
        assertThat(customerLinks, hasSize(greaterThan(0)));
        assertThat(customerLinks.get(0).getHref(), is("/qbd-api/customers/DEF-456"));
    }

    @Test
    void findByInvoiceNumber() throws Exception {
        // Given:
        when(mockSearchForInvoiceUseCase.findByInvoiceNumber(eq("406"))).thenReturn(List.of(Invoice.builder()
                .id("ABC-123")
                .invoiceNumber("406")
                .currency(Currency.getInstance("CAD"))
                .customer(Customer.builder()
                        .id("DEF-456")
                        .fullName("East India Company")
                        .build())
                .build()));

        // When:
        HttpResponse<WebInvoiceListResponse> response = client.toBlocking()
                .exchange(GET("/qbd-api/invoices/?invoiceNumber=406").basicAuth("user", "password"), Argument.of(WebInvoiceListResponse.class));

        // Then:
        assertInvoice406(response);
    }

    @Test
    void findLastInvoice() throws Exception {
        // Given:
        when(mockRetrieveInvoiceUseCase.retrieveLastInvoice()).thenReturn(List.of(Invoice.builder()
                .id("ABC-123")
                .invoiceNumber("406")
                .currency(Currency.getInstance("CAD"))
                .customer(Customer.builder()
                        .id("DEF-456")
                        .fullName("East India Company")
                        .build())
                .build()));

        // When:
        HttpResponse<WebInvoiceListResponse> response = client.toBlocking()
                .exchange(GET("/qbd-api/invoices/last-invoice").basicAuth("user", "password"), Argument.of(WebInvoiceListResponse.class));

        // Then:
        assertInvoice406(response);
    }

    @Test
    void oldFindLastInvoice_redirect() throws Exception {
        // When:
        HttpResponse<?> response = client.toBlocking()
                .exchange(GET("/qbd-api/invoices/lastInvoice").basicAuth("user", "password"), String.class);

        // Then:
        log.debug("Returned from the service call.");
        assertThat(response, notNullValue());
        assertThat(response.getStatus(), is(MOVED_PERMANENTLY));
        assertThat(response.getHeaders().get(LOCATION), is("/qbd-api/invoices/last-invoice"));
    }

    private void assertInvoice406(HttpResponse<WebInvoiceListResponse> response) throws Exception {
        assertThat(response, notNullValue());
        assertThat(response.getStatus(), is(OK));
        WebInvoiceListResponse body = response.body();
        assertThat("Null body;", body, notNullValue());
        List<WebInvoiceResponseResource> invoices = body.getInvoices();
        assertThat("Invoices;", invoices, hasSize(1));
        WebInvoiceResponseResource invoice = invoices.get(0);
        assertThat("Invoice ID;", invoice.getId(), is("ABC-123"));
        assertThat("Invoice number;", invoice.getInvoiceNumber(), is("406"));
        assertThat("Currency;", invoice.getCurrency().toString(), is("CAD"));

        OptionalMultiValues<Link> links = invoice.getLinks();
        Optional<List<Link>> selfOptional = links.get(SELF);
        assertTrue(selfOptional.isPresent(), "'self' link exists;");
        List<Link> selfLinks = selfOptional.get();
        assertThat(selfLinks, hasSize(greaterThan(0)));
        assertThat(selfLinks.get(0).getHref(), is("/qbd-api/invoices/ABC-123"));

        Optional<List<Link>> customerOptional = links.get("customer");
        assertTrue(customerOptional.isPresent(), "'customer' link exists;");
        List<Link> customerLinks = customerOptional.get();
        assertThat(customerLinks, hasSize(greaterThan(0)));
        assertThat(customerLinks.get(0).getHref(), is("/qbd-api/customers/DEF-456"));
    }
}
