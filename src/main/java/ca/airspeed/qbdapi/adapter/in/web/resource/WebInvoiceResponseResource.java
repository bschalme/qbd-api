package ca.airspeed.qbdapi.adapter.in.web.resource;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;
import java.util.Set;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.hateoas.AbstractResource;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Introspected
@Data
@EqualsAndHashCode(callSuper=false)
@Builder
public class WebInvoiceResponseResource extends AbstractResource<WebInvoiceResponseResource> {
    private String id;
    private String invoiceNumber;
    private LocalDate invoiceDate;
    private LocalDate dueDate;
    private CustomerResource customer;
    private String poNumber;
    private String terms;
    private Currency currency;
    private Set<WebInvoiceLineDetailResponse> detailLines;
    private BigDecimal subtotal;
    private BigDecimal salesTaxTotal;
    private BigDecimal balanceRemaining;
    private BigDecimal appliedAmount;
    private String notesForCustomer;
}
