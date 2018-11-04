FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080

LABEL maintainer="Brian Schalme <bschalme@airspeed.ca>"

COPY . /opt/qbd-api/
WORKDIR /opt/qbd-api/
RUN ./gradlew build && \
  cp ./build/libs/qbd-api-*.jar /opt/qbd-api.jar && \
  rm -rf /opt/qbd-api/* && \
  rm -rf ~/.gradle/

WORKDIR /opt
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "qbd-api.jar"]
