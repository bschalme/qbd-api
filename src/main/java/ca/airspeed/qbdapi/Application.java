package ca.airspeed.qbdapi;

import static java.util.Arrays.asList;

import javax.inject.Singleton;

import ca.airspeed.qbdapi.domain.Customer;
import ca.airspeed.qbdapi.repository.CustomerRepository;
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
    private CustomerRepository customerRepo;

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }

    public Application(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    @EventListener
    public void init(StartupEvent event) {
        log.info("Populating data");

        Customer megaCorp = new Customer();
        megaCorp.setName("MegaCorp Inc");
        megaCorp.setListID("1");
        Customer littleBiz = new Customer();
        littleBiz.setListID("2");
        littleBiz.setName("Little Biz");
        customerRepo.saveAll(asList(megaCorp, littleBiz));
    }
}
