# Multi-stage Dockerfile for Spring Boot (Java 17)
FROM maven:3.9.5-eclipse-temurin-17 AS build
WORKDIR /workspace
COPY pom.xml mvnw .
COPY .mvn .mvn
COPY src src
RUN mvn -B -DskipTests package

FROM eclipse-temurin:17-jre
ARG JAR_FILE=target/employee-management-system-0.0.1-SNAPSHOT.jar
COPY --from=build /workspace/${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
