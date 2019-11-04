package ca.airspeed.qbdapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/ping")
public class PingController {
    private Logger log = LoggerFactory.getLogger(PingController.class);

    @Get("/")
    public String ping() {
        log.trace("Received a ping.");
        return "{\"pong\":true}";
    }
}
