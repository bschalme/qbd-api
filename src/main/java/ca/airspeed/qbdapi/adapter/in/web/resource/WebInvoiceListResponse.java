package ca.airspeed.qbdapi.adapter.in.web.resource;

import java.util.List;

import io.micronaut.core.annotation.Introspected;
import lombok.Data;

@Introspected
@Data
public class WebInvoiceListResponse {
    private List<WebInvoiceResponseResource> invoices;

    public WebInvoiceListResponse() {
    }

    public WebInvoiceListResponse(List<WebInvoiceResponseResource> invoices) {
        this.invoices = invoices;
    }
}
