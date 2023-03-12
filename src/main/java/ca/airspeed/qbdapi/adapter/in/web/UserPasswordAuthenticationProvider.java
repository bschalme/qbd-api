package ca.airspeed.qbdapi.adapter.in.web;

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.Authentication;
import io.micronaut.security.authentication.AuthenticationProvider;
import io.micronaut.security.authentication.AuthenticationRequest;
import io.micronaut.security.authentication.AuthenticationResponse;
import io.micronaut.security.authentication.ServerAuthentication;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import jakarta.inject.Singleton;
import org.reactivestreams.Publisher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

@Singleton
@Requires(env={"localhost", "test"})
public class UserPasswordAuthenticationProvider implements AuthenticationProvider {

    private Map<String, String> users;
    private Map<String, List<String>> userGroups;

    public UserPasswordAuthenticationProvider() {
        this.users = new HashMap<>();
        this.users.put("user", "password");
        this.users.put("jsparrow", "blackpearl");
        this.users.put("eswan", "rescueme");
        this.users.put("jgibbs", "firstmate");

        this.userGroups = new HashMap<>();
        this.userGroups.put("user", asList("MyGroup"));
        this.userGroups.put("eswan", asList("AcctgVendorsPurchases"));
    }

    @Override
    public Publisher<AuthenticationResponse> authenticate(HttpRequest<?> httpRequest,
                                                          AuthenticationRequest<?, ?> authenticationRequest) {
        return Flowable.create(emitter -> {
            Authentication userDetails = doAuthenticate(authenticationRequest);
            if (userDetails != null) {
                emitter.onNext(AuthenticationResponse.success(userDetails.getName(), userDetails.getRoles()));
            }
            emitter.onComplete();
        }, BackpressureStrategy.ERROR);
    }

    private ServerAuthentication doAuthenticate(AuthenticationRequest<?, ?> authenticationRequest) {
        String identity = (String) authenticationRequest.getIdentity();
        String password = this.users.get(identity); 
        if (password != null && password.equals(authenticationRequest.getSecret())) {
            List<String> groups = this.userGroups.get(identity);
            return new ServerAuthentication(identity, groups != null ? groups : new ArrayList<>(), null);
        }
        return null;
    }
}
