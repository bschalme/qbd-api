package ca.airspeed.qbdapi.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;
import java.util.Set;

import io.micronaut.core.annotation.Introspected;
import lombok.Builder;
import lombok.Data;

@Data
@Introspected
@Builder
public class Invoice {
    private String id;
    private String invoiceNumber;
    private LocalDate invoiceDate;
    private LocalDate dueDate;
    private Customer customer;
    private String poNumber;
    private String terms;
    private Currency currency;
    private Set<InvoiceLineDetail> detailLines;
    private BigDecimal subtotal;
    private BigDecimal salesTaxTotal;
    private BigDecimal balanceRemaining;
    private BigDecimal appliedAmount;
    private String notesForCustomer;
}
