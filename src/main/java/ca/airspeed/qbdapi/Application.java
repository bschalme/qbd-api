package ca.airspeed.qbdapi;

import static java.util.Arrays.asList;

import javax.inject.Singleton;

import ca.airspeed.qbdapi.adapter.out.persistence.CustomerJpaEntity;
import ca.airspeed.qbdapi.adapter.out.persistence.CustomerJpaRepository;
import io.micronaut.context.event.StartupEvent;
import io.micronaut.core.annotation.TypeHint;
import io.micronaut.runtime.Micronaut;
import io.micronaut.runtime.event.annotation.EventListener;
import lombok.extern.slf4j.Slf4j;

// @Singleton
@TypeHint(typeNames = {
    "org.h2.Driver",
    "org.h2.mvstore.db.MVTableEngine", 
    "org.hibernate.dialect.H2Dialect",
    "com.mysql.jdbc.Driver",
    "org.hibernate.dialect.MySQL5InnoDBDialect"
})
@Slf4j
public class Application {
    private CustomerJpaRepository customerRepo;

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }

    public Application(CustomerJpaRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    @EventListener
    public void init(StartupEvent event) {
        log.info("Populating data");

        CustomerJpaEntity megaCorp = new CustomerJpaEntity();
        megaCorp.setName("MegaCorp Inc");
        megaCorp.setListID("1");
        CustomerJpaEntity littleBiz = new CustomerJpaEntity();
        littleBiz.setListID("2");
        littleBiz.setName("Little Biz");
        customerRepo.saveAll(asList(megaCorp, littleBiz));
    }
}
