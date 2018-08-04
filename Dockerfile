FROM openjdk:8-jdk-slim

ADD target/spring-cloud-netflix-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT java $JAVA_OPTS -jar app.jar
EXPOSE 8080
