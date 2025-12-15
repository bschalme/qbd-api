package ca.airspeed.qbdapi.adapter.in.web;

import static io.micronaut.http.HttpResponse.created;
import static io.micronaut.http.hateoas.Link.SELF;
import static java.lang.String.format;

import ca.airspeed.qbdapi.adapter.in.web.model.WebCreditCardCharge;
import ca.airspeed.qbdapi.adapter.in.web.resource.CreditCardChargeResponseResource;
import ca.airspeed.qbdapi.adapter.in.web.resource.WebCreditCardChargeMapper;
import ca.airspeed.qbdapi.application.port.in.EnterCreditCardChargeUseCase;
import ca.airspeed.qbdapi.domain.CreditCardCharge;
import io.micronaut.context.annotation.Value;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.authentication.Authentication;
import io.micronaut.validation.Validated;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Validated
@Controller("/credit-card-charges")
@RequiredArgsConstructor
@Slf4j
@Secured("MyGroup")
public class CreditCardChargeController {

    private final EnterCreditCardChargeUseCase enterCreditCardChargeUseCase;

    @Value("${micronaut.server.context-path:}")
    private String serverContextPath;

    /**
     * Add a new Credit Card Charge.
     * 
     * @param creditCardCharge
     * @param authn
     * @return
     */
    @ApiResponse(responseCode = "201", description = "Successfully created.")
    @ApiResponse(responseCode = "500", description = "Something horrible happened on our end.")
    @Post
    @ExecuteOn(TaskExecutors.IO)
    public HttpResponse<CreditCardChargeResponseResource> enterCreditCardCharge(
            @Body @Valid WebCreditCardCharge creditCardCharge, Authentication authn) {
        CreditCardCharge domainCreditCardCharge = WebCreditCardChargeMapper.INSTANCE.webCreditCardChargeToDomainObject(creditCardCharge);
        CreditCardCharge savedCreditCardCharge = enterCreditCardChargeUseCase
                .enterCreditCardCharge(domainCreditCardCharge);
        CreditCardChargeResponseResource response = new CreditCardChargeResponseResource();
        response.link(SELF, format("%s/credit-card-charges/%s", serverContextPath, savedCreditCardCharge.getId()));
        log.info("Principal '{}' created CreditCardCharge '{}'", authn.getName(), savedCreditCardCharge.getId());
        return created(response);
    }
}
