package ca.airspeed.qbdapi.adapter.in.web;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Singleton;

import org.reactivestreams.Publisher;

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.AuthenticationProvider;
import io.micronaut.security.authentication.AuthenticationRequest;
import io.micronaut.security.authentication.AuthenticationResponse;
import io.micronaut.security.authentication.UserDetails;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;

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
            UserDetails userDetails = doAuthenticate(authenticationRequest);
            if (userDetails != null) {
                emitter.onNext(userDetails);
            }
            emitter.onComplete();
        }, BackpressureStrategy.ERROR);
    }

    private UserDetails doAuthenticate(AuthenticationRequest<?, ?> authenticationRequest) {
        String identity = (String) authenticationRequest.getIdentity();
        String password = this.users.get(identity); 
        if (password != null && password.equals(authenticationRequest.getSecret())) {
            List<String> groups = this.userGroups.get(identity);
            return new UserDetails(identity, groups != null ? groups : new ArrayList<>());
        }
        return null;
    }
}
