package ca.airspeed.qbdapi.application.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ca.airspeed.qbdapi.application.port.out.InvoicePort;
import ca.airspeed.qbdapi.domain.Invoice;

@ExtendWith(MockitoExtension.class)
class InvoiceServiceUnitTest {

    @InjectMocks
    private InvoiceService service;

    @Mock
    private InvoicePort mockInvoicePort;

    @Test
    void retrieveInvoice() throws Exception {
        // Given:
        Invoice invoice = Invoice.builder()
                .id("ABC-123")
                .invoiceNumber("609")
                .build();
        when(mockInvoicePort.findById(eq("ABC-123"))).thenReturn(invoice);

        // When:
        Invoice result = service.retrieveInvoice("ABC-123");

        // Then:
        assertThat("Resulting Invoice;", result, notNullValue());
        assertThat("Invoice ID;", result.getId(), is("ABC-123"));
        assertThat("Invoice Number;", result.getInvoiceNumber(), is("609"));
    }

    @Test
    void findByInvoiceNumber() throws Exception {
        // Given:
        Invoice invoice = Invoice.builder()
                .id("ABC-123")
                .invoiceNumber("609")
                .build();
        when(mockInvoicePort.findByInvoiceNumber(eq("609"))).thenReturn(List.of(invoice));

        // When:
        List<Invoice> results = service.findByInvoiceNumber("609");

        // Then:
        assertThat("Result set;", results, hasSize(1));
        Invoice result = results.get(0);
        assertThat("Invoice ID;", result.getId(), is("ABC-123"));
        assertThat("Invoice Number;", result.getInvoiceNumber(), is("609"));
    }
}
