# QBD API

[![Docker Automated build](https://img.shields.io/docker/automated/bschalme/qbd-api.svg?style=flat-square)](https://hub.docker.com/r/bschalme/qbd-api/builds/)
[![Image Size](https://images.microbadger.com/badges/image/bschalme/qbd-api.svg)](https://microbadger.com/images/bschalme/qbd-api)


An API for [QuickBooks Desktop](https://quickbooks.intuit.com/ca/desktop/premier/) (QBD). This uses the MySQL database created by Synergration's 
[OpenSync](http://synergration.com/software/opensync/) as its backing datastore. You simply issue REST-ful HTTP calls against QBD API and it will fetch and persist the data.

Of course, you will need OpenSync running and a licensed copy of QuickBooks Desktop to synchronize the MySQL database with QuickBooks.

## Design

This is an example of a [Hexagonal Architecture](https://en.wikipedia.org/wiki/Hexagonal_architecture_(software)) (also known as Ports and Adapters Architecture). In contrast to a layered
architecture (such as Model-View-Controller), this further enforces a separation of concerns by making it more difficult for logic to bleed across concerns.

Having a great deal of experience with layered MVC web applications, I found it rather difficult to wrap my head around the implementation of a Hexagonal Architecture. But after plowing
through I actually find it quite liberating. When you need focus on the application core (the business logic), you are freed from the details of incoming connections and outgoing 
database persistence. 

## To build QBD API

```
./gradlew build
```

## To run QBD API

```
java -jar build/libs/qbd-api-1.0.0-SNAPSHOT-all.jar 
```

Alternately, you can use Docker:

1. docker build -t yourUserName/qbd-api:latest .
2. docker run --rm -p 8080:8080 yourUserName/qbd-api:latest

## To Check the Health of QBD API

```
curl --include -X GET http://localhost:8080/qbd-api/manage/health
``` 

You should get an HTTP Status code 200 OK, along with a little JSON that says "status" is "UP".

## To run QBD API Against a MySQL Database

1. Edit `build.gradle` and comment out the H2 dependency and un-comment the MySQL dependency;
2. Un-comment the DataSource bean in `Application.java`; and 
3. Instead of an application.properties file, QBD API uses [Spring Cloud Config](https://cloud.spring.io/spring-cloud-config/) at localhost:8888. Make a qbd-api.properties in the Spring Cloud Config server that holds these properties, substituting the placeholders for real values:

```
configuration.projectName = qbd-api
spring.datasource.url = jdbc:mysql://${hostname}:3306/${databaseName}?useSSL=false
spring.datasource.username = ${dbUsername}
spring.datasource.password = ${dbPassword}
spring.jpa.hibernate.naming.physical-strategy = org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
```

The `PhysicalNamingStrategyStandardImpl` is important because QuickBooks uses UpperCamelCase instead of snake_case for their table and column names.

Build it and run it.
