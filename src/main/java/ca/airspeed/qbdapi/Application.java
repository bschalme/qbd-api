package ca.airspeed.qbdapi;

import io.micronaut.runtime.Micronaut;

public class Application {
    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }

//    @Bean
//    @Primary
//    @ConfigurationProperties(prefix="spring.datasource")
//    public DataSource primaryDataSourde() {
//        return DataSourceBuilder.create().build();
//    }
}
