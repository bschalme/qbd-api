package ca.airspeed.qbdapi.adapter.out.persistence.invoice;

import static java.time.ZoneId.systemDefault;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.airspeed.qbdapi.adapter.out.persistence.customer.CustomerJpaEntity;
import ca.airspeed.qbdapi.domain.Customer;
import ca.airspeed.qbdapi.domain.Invoice;
import ca.airspeed.qbdapi.domain.InvoiceLineDetail;
import ca.airspeed.qbdapi.domain.ServiceItem;

class InvoiceJpaMapperUnitTest {

    private InvoiceJpaMapper mapper;

    @BeforeEach
    void setUp() throws Exception {
        mapper = InvoiceJpaMapper.INSTANCE;
    }

    @Test
    void jpaEntityToInvoice() throws Exception {
        // Given:
        LocalDate today = LocalDate.now();
        InvoiceJpaEntity entity = new InvoiceJpaEntity();
        entity.setTxnID("ABC-123");
        entity.setTxnDate(Date.from(today.atStartOfDay(systemDefault()).toInstant()));
        entity.setDueDate(Date.from(today.plusDays(30).atStartOfDay(systemDefault()).toInstant()));
        entity.setRefNumber("409");
        entity.setCustomerMsgRefFullName("Hello World!");
        CustomerJpaEntity customerEntity = new CustomerJpaEntity();
        customerEntity.setListID("GHI-789");
        customerEntity.setFullName("East India Company");
        entity.setCustomer(customerEntity);
        InvoiceLineDetailJpaEntity entityDetail = new InvoiceLineDetailJpaEntity();
        entityDetail.setTxnLineID("DEF-456");
        entityDetail.setItemRefListID("XYZ-987");
        entityDetail.setItemRefFullName("45-foot Sail");
        entityDetail.setDescription("Sail, 45-foot");
        entityDetail.setAmount(BigDecimal.valueOf(45.25));
        entity.getDetailLines().add(entityDetail);

        // When:
        Invoice result = mapper.jpaEntityToInvoice(entity);

        // Then:
        assertThat(result, notNullValue());
        assertThat(result.getId(), is("ABC-123"));
        assertThat("Invoice number;", result.getInvoiceNumber(), is("409"));
        assertThat("Invoice date;", result.getInvoiceDate(), is(today));
        assertThat("Due date;", result.getDueDate(), is(today.plusDays(30)));
        assertThat("Notes for Customer;", result.getNotesForCustomer(), is("Hello World!"));
        Customer customer = result.getCustomer();
        assertThat("Customer;", customer, notNullValue());
        assertThat("Customer ID;", customer.getId(), is("GHI-789"));
        assertThat("Customer full name;", customer.getFullName(), is("East India Company"));
        assertThat("Detail lines;", result.getDetailLines(), hasSize(1));
        Iterator<InvoiceLineDetail> iterator = result.getDetailLines().iterator();
        InvoiceLineDetail resultDetail = iterator.next();
        assertThat(resultDetail.getId(), is("DEF-456"));
        ServiceItem serviceItem = resultDetail.getServiceItem();
        assertThat("Invoice detail Service Item;", serviceItem, notNullValue());
        assertThat(serviceItem.getId(), is("XYZ-987"));
        assertThat(serviceItem.getFullName(), is("45-foot Sail"));
        assertThat(resultDetail.getDescription(), is("Sail, 45-foot"));
        assertThat(resultDetail.getAmount(), is(BigDecimal.valueOf(45.25)));
    }
}
