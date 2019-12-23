package ca.airspeed.qbdapi.controller;

import static java.lang.String.format;

import io.micronaut.context.annotation.Value;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import lombok.extern.slf4j.Slf4j;

@Controller("/ping")
@Slf4j
public class PingController {

    @Value("${datasources.default.username:unknown}")
    private String dbUsername;

    @Get("/")
    public String ping() {
        log.trace("Received a ping.");
        return format("{\"pong\":true,\"db.username\":\"%s\"}", dbUsername);
    }
}
