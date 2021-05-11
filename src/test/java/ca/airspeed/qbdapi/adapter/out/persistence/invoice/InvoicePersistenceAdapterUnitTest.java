package ca.airspeed.qbdapi.adapter.out.persistence.invoice;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ca.airspeed.qbdapi.domain.Invoice;

@ExtendWith(MockitoExtension.class)
class InvoicePersistenceAdapterUnitTest {

    @InjectMocks
    private InvoicePersistenceAdapter adapter;

    @Mock
    private InvoiceJpaRepository mockInvoiceRepo;

    @Test
    void findById() throws Exception {
        // Given:
        String id = "ABC-123";
        InvoiceJpaEntity entity = new InvoiceJpaEntity();
        entity.setTxnID("ABC-123");
        entity.setBalanceRemaining(BigDecimal.valueOf(4598.34));
        when(mockInvoiceRepo.findById(id)).thenReturn(Optional.of(entity));

        // When:
        Invoice result = adapter.findById(id);

        // Then:
        assertThat(result, notNullValue());
    }

    @Test
    void findByInvoiceNumber() throws Exception {
        // Given:
        String refNumber = "609";
        InvoiceJpaEntity entity = new InvoiceJpaEntity();
        entity.setTxnID("ABC-123");
        entity.setRefNumber(refNumber);
        entity.setBalanceRemaining(BigDecimal.valueOf(4598.34));
        when(mockInvoiceRepo.findByRefNumber(refNumber)).thenReturn(List.of(entity));

        // When:
        List<Invoice> results = adapter.findByInvoiceNumber(refNumber);

        // Then:
        assertThat("Result set;", results, hasSize(1));
        Invoice result = results.get(0);
        assertThat("Invoice number;", result.getInvoiceNumber(), is("609"));
    }
}
