package ca.airspeed.qbdapi.adapter.in.web.resource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.airspeed.qbdapi.adapter.in.web.model.WebAccount;
import ca.airspeed.qbdapi.adapter.in.web.model.WebCreditCardCharge;
import ca.airspeed.qbdapi.adapter.in.web.model.WebVendor;
import ca.airspeed.qbdapi.domain.Account;
import ca.airspeed.qbdapi.domain.CreditCardCharge;

class WebCreditCardChargeMapperUnitTest {

    private WebCreditCardChargeMapper mapper;

    @BeforeEach
    void setUp() throws Exception {
        mapper = WebCreditCardChargeMapper.INSTANCE;
    }

    @Test
    void domainObjectToWebCreditCardChargeResponseResource() throws Exception {
        // Given:
        CreditCardCharge domainObject = CreditCardCharge.builder()
                .account(Account.builder()
                        .id("DEF-456")
                        .build())
                .amount(BigDecimal.valueOf(1327, 2))
                .id("ABC-123")
                .build();

        // When:
        CreditCardChargeResponseResource result = mapper.domainObjectToCreditCardChargeResponseResource(domainObject);

        // Then:
        assertThat(result, notNullValue());
        assertThat(result.getId(), is("ABC-123"));
        AccountResponse account = result.getAccount();
        assertThat("Account;", account, notNullValue());
        assertThat("Account ID;", account.getId(), is("DEF-456"));
        assertThat(result.getAmount(), is(BigDecimal.valueOf(1327, 2)));
    }

    @Test
    void webCreditCardChargeToDomainObject() throws Exception {
        // Given:
        WebCreditCardCharge charge = new WebCreditCardCharge();
        WebAccount webAccount = new WebAccount();
        webAccount.setId("DEF-456");
        webAccount.setName("American Express");
        charge.setAccount(webAccount);
        WebVendor webPayee = new WebVendor();
        webPayee.setId("GHI-789");
        webPayee.setName("East India Company");
        charge.setPayee(webPayee);
        charge.setAmount(BigDecimal.valueOf(1327, 2));

        // When:
        CreditCardCharge result = mapper.webCreditCardChargeToDomainObject(charge);

        // Then:
        assertThat(result, notNullValue());
        Account account = result.getAccount();
        assertThat("Account;", account, notNullValue());
    }

}
