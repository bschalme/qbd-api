package ca.airspeed.qbdapi.adapter.in.web;

import static io.micronaut.http.hateoas.Link.SELF;
import static java.lang.String.format;

import ca.airspeed.qbdapi.adapter.in.web.resource.WebInvoiceMapper;
import ca.airspeed.qbdapi.adapter.in.web.resource.WebInvoiceResponseResource;
import ca.airspeed.qbdapi.application.port.in.RetrieveInvoiceUseCase;
import ca.airspeed.qbdapi.domain.Customer;
import ca.airspeed.qbdapi.domain.Invoice;
import io.micronaut.context.annotation.Value;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.authentication.Authentication;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller("/invoices")
@RequiredArgsConstructor
@Slf4j
@Secured("MyGroup")
public class InvoiceController {

    private final RetrieveInvoiceUseCase retrieveInvoiceUseCase;

    @Value("${micronaut.server.context-path:}")
    private String serverContextPath;


    @Get("/{id}")
    @ExecuteOn(TaskExecutors.IO)
    public WebInvoiceResponseResource findById(String id, Authentication authn) {
        Invoice invoice = retrieveInvoiceUseCase.retrieveInvoice(id);
        WebInvoiceResponseResource response = WebInvoiceMapper.INSTANCE.domainObjectToWebInvoiceResponseResource(invoice);
        log.info("Principal '{}' retrieved Invoice ID '{}', Invoice number '{}'.", authn.getName(), response.getId(),
                response.getInvoiceNumber());
        response.link(SELF, format("%s/invoices/%s", serverContextPath, id));
        Customer customer = invoice.getCustomer();
        if (customer != null) {
            response.link("customer", format("%s/customers/%s", serverContextPath, customer.getId()));
        }
        return response;
    }
}
