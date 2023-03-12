package ca.airspeed.qbdapi.adapter.in.web;

import static io.micronaut.core.util.CollectionUtils.mapOf;
import static io.micronaut.security.rules.SecurityRule.IS_ANONYMOUS;

import java.util.LinkedHashMap;
import java.util.Map;

import io.micronaut.core.annotation.Nullable;
import jakarta.inject.Inject;

import io.micronaut.context.annotation.Value;
import io.micronaut.context.env.Environment;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.context.ServerContextPathProvider;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.authentication.Authentication;
import lombok.extern.slf4j.Slf4j;

@Controller("/ping")
@Slf4j
public class PingController {

//    @Value("${datasources.default.username:unknown}")
    @Value("${DB_USERNAME:unknown}")
    private String dbUsername;

    @Inject
    private Environment env;

    @Inject
    private ServerContextPathProvider contextPathProvider;

    /**
     * Retrieve arbitrary information. Useful for troubleshooting.
     * 
     * @param authentication
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Secured(IS_ANONYMOUS)
    @Get("/")
    @ExecuteOn(TaskExecutors.IO)
    public Map ping(@Nullable Authentication authentication) {
        log.trace("Received a ping.");
        String dbHost = System.getenv("DB_HOST");
        Map result = new LinkedHashMap();
        if (authentication == null) {
            result.put("isLoggedIn", false);
        }
        else {
            result.putAll(mapOf("isLoggedIn", true,
                    "username", authentication.getName(),
                    "groups", authentication.getAttributes().get("cognito:groups")));
        }
        result.putAll(mapOf("pong", true,
                "db.username", dbUsername,
                "db.host", dbHost,
                "environments", env.getActiveNames(),
                "contextPath", contextPathProvider.getContextPath()));
        return result;
    }
}
