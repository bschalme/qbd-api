package ca.airspeed.qbdapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Bean
//    @Primary
//    @ConfigurationProperties(prefix="spring.datasource")
//    public DataSource primaryDataSourde() {
//        return DataSourceBuilder.create().build();
//    }
}
