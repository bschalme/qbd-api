package ca.airspeed.qbdapi.adapter.in.web;

import static io.micronaut.http.hateoas.Link.SELF;
import static java.lang.String.format;

import ca.airspeed.qbdapi.adapter.in.web.resource.DividendSummaryResponseResource;
import ca.airspeed.qbdapi.application.port.in.RetrieveDividendHistoryUseCase;
import ca.airspeed.qbdapi.domain.DividendSummary;
import io.micronaut.context.annotation.Value;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.authentication.Authentication;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller("/dividends")
@Slf4j
@Secured({ "MyGroup" })
@RequiredArgsConstructor
public class DividendController {

    private final RetrieveDividendHistoryUseCase retrieveDividends;

    @Value("${micronaut.server.context-path:}")
    private String serverContextPath;

    @Get("/dividend-history")
    public DividendSummaryResponseResource retrieveDividendHistory(Authentication authn) {
        log.info("Principal '{}' asked for dividend history.", authn.getName());
        DividendSummary summary = retrieveDividends.retrieveDividendHistory();
        DividendSummaryResponseResource response =  new DividendSummaryResponseResource(summary.getDividendYears());
        response.link(SELF, format("%s/dividends/dividend-history", serverContextPath));
        return response;
    }
}
