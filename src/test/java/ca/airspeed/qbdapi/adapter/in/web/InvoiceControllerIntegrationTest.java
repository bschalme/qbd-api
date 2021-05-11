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

import ca.airspeed.qbdapi.adapter.in.web.resource.CustomerResource;
import ca.airspeed.qbdapi.adapter.in.web.resource.WebInvoiceListResponse;
import ca.airspeed.qbdapi.adapter.in.web.resource.WebInvoiceResponseResource;
import ca.airspeed.qbdapi.application.port.in.RetrieveInvoiceUseCase;
import ca.airspeed.qbdapi.application.port.in.SearchForInvoiceUseCase;
import ca.airspeed.qbdapi.domain.Customer;
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
                .customer(Customer.builder()
                        .id("DEF-456")
                        .fullName("East India Company")
                        .build())
                .build()));

        // When:
        HttpResponse<WebInvoiceListResponse> response = client
                .exchange(GET("/qbd-api/invoices/?invoiceNumber=406").basicAuth("user", "password"), WebInvoiceListResponse.class)
                .blockingFirst();

        // Then:
        assertThat(response, notNullValue());
        assertThat(response.getStatus(), is(OK));
        WebInvoiceListResponse body = response.body();
        assertThat("Null body;", body, notNullValue());
        List<WebInvoiceResponseResource> invoices = body.getInvoices();
        assertThat("Invoices;", invoices, hasSize(1));
        WebInvoiceResponseResource invoice = invoices.get(0);
        assertThat("Invoice ID;", invoice.getId(), is("ABC-123"));
        assertThat("Invoice number;", invoice.getInvoiceNumber(), is("406"));

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
