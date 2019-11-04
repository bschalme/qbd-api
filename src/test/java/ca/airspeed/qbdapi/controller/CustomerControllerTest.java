package ca.airspeed.qbdapi.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.annotation.MicronautTest;

@MicronautTest
public class CustomerControllerTest {
    @Inject
    private EmbeddedServer embeddedServer;

@Test
public void getAllCustomers() throws Exception {
    try (RxHttpClient client = embeddedServer.getApplicationContext().createBean(RxHttpClient.class,
            embeddedServer.getURL())) {
        assertEquals(HttpStatus.OK, client.toBlocking().exchange("/customers").status());
    }
}
}
