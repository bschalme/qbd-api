package ca.airspeed.qbdapi;

import static java.util.Arrays.asList;

import javax.inject.Singleton;

import ca.airspeed.qbdapi.adapter.out.persistence.CustomerJpaEntity;
import ca.airspeed.qbdapi.adapter.out.persistence.CustomerJpaRepository;
import io.micronaut.context.annotation.Requires;
import io.micronaut.context.event.StartupEvent;
import io.micronaut.core.annotation.TypeHint;
import io.micronaut.runtime.Micronaut;
import io.micronaut.runtime.event.annotation.EventListener;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
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
                ))
public class Application {
    private CustomerJpaRepository customerRepo;

    public static void main(String[] args) {
        Micronaut.build(args)
                .mainClass(Application.class)
                .start();
    }

    public Application(CustomerJpaRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    @EventListener
    @Requires(env="localhost")
    void init(StartupEvent event) {
        log.info("Populating data");

        customerRepo.deleteAll();
        CustomerJpaEntity megaCorp = new CustomerJpaEntity();
        megaCorp.setFullName("MegaCorp Inc:Solution Architecture");
        megaCorp.setName("Solution Architecture");
        megaCorp.setListID("1");
        CustomerJpaEntity littleBiz = new CustomerJpaEntity();
        littleBiz.setListID("2");
        littleBiz.setFullName("Little Biz:Gardening");
        littleBiz.setName("Gardening");
        customerRepo.saveAll(asList(megaCorp, littleBiz));
    }
}
