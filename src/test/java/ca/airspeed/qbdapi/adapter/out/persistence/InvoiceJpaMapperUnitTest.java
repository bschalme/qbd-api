package ca.airspeed.qbdapi.adapter.out.persistence;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.airspeed.qbdapi.domain.Invoice;

class InvoiceJpaMapperUnitTest {

    private InvoiceJpaMapper mapper;

    @BeforeEach
    void setUp() throws Exception {
        mapper = InvoiceJpaMapper.INSTANCE;
    }

    @Test
    void jpaEntityToInvoice() throws Exception {
        // Given:
        InvoiceJpaEntity entity = new InvoiceJpaEntity();
        entity.setTxnID("ABC-123");

        // When:
        Invoice result = mapper.jpaEntityToInvoice(entity);

        // Then:
        assertThat(result, notNullValue());
    }
}
