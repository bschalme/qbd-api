package ca.airspeed.qbdapi;

import static io.swagger.v3.oas.annotations.enums.SecuritySchemeType.HTTP;

import javax.inject.Singleton;

import ca.airspeed.qbdapi.application.port.in.CreateCustomerUseCase;
import ca.airspeed.qbdapi.domain.Customer;
import io.micronaut.context.annotation.Requires;
import io.micronaut.context.event.StartupEvent;
import io.micronaut.core.annotation.TypeHint;
import io.micronaut.runtime.Micronaut;
import io.micronaut.runtime.event.annotation.EventListener;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Singleton
@TypeHint(typeNames = {
    "org.h2.Driver",
    "org.h2.mvstore.db.MVTableEngine", 
    "org.hibernate.dialect.H2Dialect",
    "com.mysql.jdbc.Driver",
    "org.hibernate.dialect.MySQL5InnoDBDialect"
})
@Slf4j
@OpenAPIDefinition(
        info = @Info(
                title = "QBD API",
                version = "1.0.0-SNAPSHOT",
                description = "A REST-ful API for interacting with QuickBooks Desktop by way of Synergration Software's OpenSync.",
                license = @License(name = "Apache 2.0", url = "https://github.com/bschalme/qbd-api/blob/master/LICENSE"),
                contact = @Contact(url = "https://airspeed.ca", name = "Brian Schalme", email = "bschalme@airspeed.ca")
                ),
        security = {
                @SecurityRequirement(name="basicAuth"),
                @SecurityRequirement(name="bearer")
        }
)
@SecurityScheme(name = "basicAuth", type = HTTP, scheme = "basic", description = "For localhost testing and development")
@SecurityScheme(name = "bearer", type = HTTP, scheme = "bearer", bearerFormat = "JWT", description = "For test and higher environments including Production")
@RequiredArgsConstructor
public class Application {

    private final CreateCustomerUseCase createCustomerUseCase;

    public static void main(String[] args) {
        Micronaut.build(args)
                .mainClass(Application.class)
                .start();
    }

    @EventListener
    @Requires(env="localhost")
    void init(StartupEvent event) {
        log.info("Populating data");

//        timeTrackingRepo.deleteAll();
//        customerRepo.deleteAll();
        Customer megaCorp = Customer.builder()
                .fullName("MegaCorp Inc:Solution Architecture")
                .name("Solution Architecture")
                .build();
        Customer littleBiz = Customer.builder()
                .fullName("Little Biz:Gardening")
                .name("Gardening")
                .build();
        Customer def456 = Customer.builder()
                .fullName("MegaCorp:Cloud Migration")
                .name("Cloud Migration")
                .build();
        createCustomerUseCase.createCustomer(megaCorp);
        createCustomerUseCase.createCustomer(littleBiz);
        createCustomerUseCase.createCustomer(def456);
    }
}
