package ca.airspeed.qbdapi.adapter.in.web.resource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.airspeed.qbdapi.domain.Customer;
import ca.airspeed.qbdapi.domain.Invoice;
import ca.airspeed.qbdapi.domain.InvoiceLineDetail;
import ca.airspeed.qbdapi.domain.Item;

class WebInvoiceMapperUnitTest {
    private WebInvoiceMapper mapper;

    @BeforeEach
    void setUp() throws Exception {
        mapper = WebInvoiceMapper.INSTANCE;
    }

    @Test
    void domainObjectToWebInvoiceResponseResource() throws Exception {
        // Given:
        Currency cad = Currency.getInstance("CAD");
        Invoice domainInvoice = Invoice.builder()
                .id("ABC-123")
                .invoiceNumber("409")
                .currency(cad)
                .customer(Customer.builder()
                        .id("DEF-456")
                        .name("East India Company")
                        .build())
                .currency(Currency.getInstance("CAD"))
                .detailLines(Set.of(InvoiceLineDetail.builder()
                        .id("GHI-789")
                        .item(Item.builder()
                                .id("XYZ-987")
                                .fullName("Rum Bottles")
                                .build())
                        .description("Rum, bottles")
                        .quantity(BigDecimal.valueOf(12, 0))
                        .build(),
                        InvoiceLineDetail.builder()
                        .id("JKL-012")
                        .item(Item.builder()
                                .id("WXY-765")
                                .fullName("Chest, Treasure")
                                .build())
                        .description("Treasure chest")
                        .quantity(BigDecimal.valueOf(2))
                        .build()))
                .build();

        // When:
        WebInvoiceResponseResource result = mapper.domainObjectToWebInvoiceResponseResource(domainInvoice);

        // Then:
        assertThat(result, notNullValue());
        assertThat("Invoice number;", result.getInvoiceNumber(), is("409"));
        assertThat("Currency;", result.getCurrency(), is(cad));
        CustomerResource customer = result.getCustomer();
        assertThat("Customer;", customer, notNullValue());
        assertThat("Customer ID;", customer.getId(), is("DEF-456"));
        assertThat("Customer name;", customer.getName(), is("East India Company"));
        Set<WebInvoiceLineDetailResponse> details = result.getDetailLines();
        assertThat("Detail line count;", details, hasSize(2));
        Optional<WebInvoiceLineDetailResponse> detailOptional = details.stream()
                .filter(invDetail -> invDetail.getId().equals("GHI-789"))
                .findFirst();
        WebInvoiceLineDetailResponse detail = detailOptional.get();
        assertThat("Invoice Line Detail ID;", detail.getId(), is("GHI-789"));
        WebItemResponse item = detail.getItem();
        assertThat("Invoice detail Item;", item, notNullValue());
        assertThat(item.getId(), is("XYZ-987"));
        assertThat(item.getFullName(), is("Rum Bottles"));
    }
}
