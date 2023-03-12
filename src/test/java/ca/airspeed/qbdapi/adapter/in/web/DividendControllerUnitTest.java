package ca.airspeed.qbdapi.adapter.in.web;

import static io.micronaut.http.HttpRequest.GET;
import static io.micronaut.http.HttpStatus.FORBIDDEN;
import static io.micronaut.http.HttpStatus.OK;
import static io.micronaut.http.HttpStatus.UNAUTHORIZED;
import static io.micronaut.http.hateoas.Link.SELF;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import io.micronaut.core.type.Argument;
import io.micronaut.http.client.HttpClient;
import jakarta.inject.Inject;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import ca.airspeed.qbdapi.adapter.in.web.resource.DividendSummaryResponseResource;
import ca.airspeed.qbdapi.application.port.in.RetrieveDividendHistoryUseCase;
import ca.airspeed.qbdapi.domain.DividendSummary;
import ca.airspeed.qbdapi.domain.DividendYear;
import io.micronaut.core.value.OptionalMultiValues;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.http.hateoas.Link;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;

@MicronautTest
class DividendControllerUnitTest {

    @Inject
    private RetrieveDividendHistoryUseCase mockRetrieveDividends;

    @Inject
    @Client("/")
    HttpClient client;

    @MockBean(RetrieveDividendHistoryUseCase.class)
    RetrieveDividendHistoryUseCase mockRetrieveDividends() {
        return mock(RetrieveDividendHistoryUseCase.class);
    }

    @Test
    void unauthenticatedUser_fails() throws Exception {
        // When:
        Executable e = () -> client.toBlocking().exchange(GET("/qbd-api/dividends/dividend-history"), DividendSummaryResponseResource.class);

        // Then:
        HttpClientResponseException chucked = assertThrows(HttpClientResponseException.class, e);
        assertEquals(UNAUTHORIZED, chucked.getStatus());
    }

    @Test
    void unauthorizedUser_fails() throws Exception {
        // When:
        Executable e = () -> client.toBlocking().exchange(
                GET("/qbd-api/dividends/dividend-history").basicAuth("eswan", "rescueme"),
                DividendSummaryResponseResource.class);

        // Then:
        HttpClientResponseException chucked = assertThrows(HttpClientResponseException.class, e);
        assertEquals(FORBIDDEN, chucked.getStatus());
    }

    @Test
    void retrieveDividendHistory() throws Exception {
        // Given:
        when(mockRetrieveDividends.retrieveDividendHistory())
                .thenReturn(new DividendSummary(asList(new DividendYear(2020, BigDecimal.valueOf(1234.56D)))));

        // When:
        HttpResponse<DividendSummaryResponseResource> response = client.toBlocking()
                .exchange(GET("/qbd-api/dividends/dividend-history").basicAuth("user", "password"), Argument.of(DividendSummaryResponseResource.class));

        // Then:
        assertThat(response, notNullValue());
        assertThat(response.getStatus(), is(OK));
        DividendSummaryResponseResource body = response.body();
        assertThat("Response body;", body, notNullValue());
        List<DividendYear> dividendYears = body.getDividendHistory();
        assertThat(dividendYears, hasSize(1));
        DividendYear firstYear = dividendYears.get(0);
        assertThat("Year;", firstYear.getYear(), is(2020));
        assertThat("Amount;", firstYear.getDividends(), is(BigDecimal.valueOf(1234.56D)));
        OptionalMultiValues<Link> links = body.getLinks();
        Optional<List<Link>> selfOptional = links.get(SELF);
        assertTrue(selfOptional.isPresent(), "Missing 'self' link;");
        List<Link> selfLinks = selfOptional.get();
        assertThat(selfLinks, hasSize(greaterThan(0)));
        assertThat(selfLinks.get(0).getHref(), is("/qbd-api/dividends/dividend-history"));
    }
}
