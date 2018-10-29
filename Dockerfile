FROM openjdk:8-jdk-alpine
MAINTAINER "Luiz Evangelista <luizhenrique.se@gmail.com>"

VOLUME /tmp
VOLUME /config

ARG JAR_FILE
ADD ${JAR_FILE} app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]