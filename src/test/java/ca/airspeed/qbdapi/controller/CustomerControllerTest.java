package ca.airspeed.qbdapi.controller;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import ca.airspeed.qbdapi.domain.Customer;
import ca.airspeed.qbdapi.repository.CustomerRepository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.annotation.MicronautTest;
import io.micronaut.test.annotation.MockBean;

@MicronautTest
public class CustomerControllerTest {
    @Inject
    private EmbeddedServer embeddedServer;

    @Inject
    private CustomerRepository mockRepo;

    @Test
    public void getAllCustomers() throws Exception {
        when(mockRepo.findAll(isA(Pageable.class))).thenReturn(twoCustomers());
        try (RxHttpClient client = embeddedServer.getApplicationContext().createBean(RxHttpClient.class,
                embeddedServer.getURL())) {
            Page<?> body = client.toBlocking().retrieve("/customers", Page.class);
            verify(mockRepo).findAll(isA(Pageable.class));
            assertNotNull(body, "Response body is null.");
            assertEquals(body.getNumberOfElements(), 2);
        }
    }

    private Page<Customer> twoCustomers() {
        Customer megaCorp = new Customer();
        megaCorp.setListID("1");
        megaCorp.setName("MegaCorp");
        Customer littleBiz = new Customer();
        littleBiz.setListID("2");
        littleBiz.setName("Little Biz");
        Pageable pageable = Pageable.from(0);
        Page<Customer> result = Page.of(asList(megaCorp, littleBiz), pageable, 2L);
        return result;
    }

    @MockBean(CustomerRepository.class)
    CustomerRepository customerRepository() {
        return mock(CustomerRepository.class);
    }

}
