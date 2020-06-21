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

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

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
    @Inject
    private EmbeddedServer embeddedServer; 

    @Inject
    @Client("/")
    private RxHttpClient client; 

    @Inject
    private CustomerRepository mockRepo;

    @Inject
    private ObjectMapper mapper;

    @BeforeEach
    public void setUp() throws Exception {
//      Customer megaCorp = new Customer();
//      megaCorp.setName("MegaCorp Inc");
//      megaCorp.setListID("1");
//      megaCorp.setIsActive("false");
//      Customer littleBiz = new Customer();
//      littleBiz.setListID("2");
//      littleBiz.setName("Little Biz");
//      littleBiz.setIsActive("true");
//      mockRepo.saveAll(asList( littleBiz));
   }

    @AfterEach
    public void tearDown() throws Exception {
//        mockRepo.deleteAll();
    }

    @Test
    public void getAllCustomers() throws Exception {
        // when(mockRepo.findAll(isA(Pageable.class))).thenReturn(twoCustomers());
//        try (RxHttpClient client = embeddedServer.getApplicationContext().createBean(RxHttpClient.class,
//                embeddedServer.getURL())) {
            Page<?> body = client.toBlocking().retrieve("/qbd-api/customers", Page.class);
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
            HttpRequest<String> request = GET("/qbd-api/customers/1");
//            HttpResponse<String> response = client.toBlocking().exchange(request);
//            assertEquals(HttpStatus.OK, response.status());
//            System.out.println("response is " + response);
//            Optional<String> body = response.getBody();
            String body = client.toBlocking().retrieve(request);
            assertNotNull(body, "Response body");
            System.out.println("body is " + body);
            JsonNode root = mapper.readTree(body);
//            assertNotNull(body.get());
            assertEquals(root.at("/id").asText(), "1");
            assertEquals(root.at("/name").asText(), "MegaCorp Inc");
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
