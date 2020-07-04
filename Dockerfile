FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080

LABEL maintainer="Brian Schalme <bschalme@airspeed.ca>"

ADD build/libs/qbd-api-1.0.0-SNAPSHOT-all.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]
