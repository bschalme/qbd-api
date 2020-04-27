package ca.airspeed.qbdapi.controller;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static io.micronaut.http.HttpRequest.GET;

import java.util.Optional;

import javax.inject.Inject;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import ca.airspeed.qbdapi.domain.Customer;
import ca.airspeed.qbdapi.repository.CustomerRepository;
import ca.airspeed.qbdapi.resource.CustomerResource;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.annotation.MicronautTest;
import io.micronaut.test.annotation.MockBean;

@MicronautTest
public class CustomerControllerTest {
//    @Inject
//    private EmbeddedServer embeddedServer; 

    @Inject
    @Client("/")
    private RxHttpClient client; 

    @Inject
    private CustomerRepository mockRepo;

    @BeforeEach
    public void setUp() throws Exception {
      Customer megaCorp = new Customer();
      megaCorp.setName("MegaCorp Inc");
      megaCorp.setListID("1");
      megaCorp.setIsActive("false");
      Customer littleBiz = new Customer();
      littleBiz.setListID("2");
      littleBiz.setName("Little Biz");
      littleBiz.setIsActive("true");
      mockRepo.saveAll(asList(megaCorp, littleBiz));
   }

    @AfterEach
    public void tearDown() throws Exception {
        mockRepo.deleteAll();
    }

    @Test
    @Disabled
    public void getAllCustomers() throws Exception {
        // when(mockRepo.findAll(isA(Pageable.class))).thenReturn(twoCustomers());
//        try (RxHttpClient client = embeddedServer.getApplicationContext().createBean(RxHttpClient.class,
//                embeddedServer.getURL())) {
            Page<?> body = client.toBlocking().retrieve("/customers", Page.class);
            // verify(mockRepo).findAll(isA(Pageable.class));
            assertNotNull(body, "Response body is null.");
            assertEquals(body.getNumberOfElements(), 2);
//        }
    }

    @Test
    public void getOneCustomer() throws Exception {
//        when(mockRepo.findById(isA(String.class))).thenReturn(megaCorp());
//        try (RxHttpClient client = embeddedServer.getApplicationContext().createBean(RxHttpClient.class,
//                embeddedServer.getURL())) {
            HttpResponse<CustomerResource> response = client.toBlocking().exchange("/customers/1");
            assertEquals(HttpStatus.OK, response.status());
//            CustomerResource body = response.body();
            HttpRequest<String> request = GET("/customers/1");
            CustomerResource body = client.toBlocking().retrieve(request, CustomerResource.class);
            assertNotNull(body, "Response body");
            assertEquals(body.getId(), "1");
            assertEquals(body.getName(), "MegaCorp Inc");
//        }
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

    private Optional<Customer> megaCorp() {
        Customer megaCorp = new Customer();
        megaCorp.setListID("1");
        megaCorp.setName("MegaCorp");
        return Optional.of(megaCorp);
    }

//    @MockBean(CustomerRepository.class)
//    CustomerRepository customerRepository() {
//        return mock(CustomerRepository.class);
//    }

}
