package ca.airspeed.qbdapi.adapter.in.web;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.micronaut.http.client.HttpClient;
import jakarta.inject.Inject;

import org.junit.jupiter.api.Test;

import io.micronaut.http.HttpStatus;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;


@MicronautTest
class PingControllerTest {
    @Inject
    private EmbeddedServer embeddedServer;

    @Test
    void testPing() throws Exception {
        try (HttpClient client = embeddedServer.getApplicationContext().createBean(HttpClient.class,
                embeddedServer.getURL())) {
            assertEquals(HttpStatus.OK, client.toBlocking().exchange("/qbd-api/ping").status());
        }
    }

}
