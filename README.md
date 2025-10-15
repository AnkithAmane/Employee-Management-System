# Employee Management System (Spring Boot + MySQL + Thymeleaf)

This is a ready-to-run **Spring Boot** project with a simple **Thymeleaf** web UI and **MySQL** database.

## Project name
employee-management-system

## Package
com.example.ems

## Requirements
- Java 17+
- Maven
- MySQL running locally

## Setup
1. Create a MySQL database:
   ```sql
   CREATE DATABASE employee_db;
   ```
2. Update `src/main/resources/application.properties` with your MySQL `username` and `password`.

3. Build and run:
   ```bash
   mvn clean package
   mvn spring-boot:run
   ```
   Or run the generated jar:
   ```bash
   java -jar target/employee-management-system-0.0.1-SNAPSHOT.jar
   ```

4. Open the UI:
   http://localhost:8080/employees

## Notes
- `spring.jpa.hibernate.ddl-auto=update` will create/update tables automatically (use cautiously in production).
- For quick testing without MySQL, you can change datasource to an H2 in-memory database.

## Quick start (alternative: H2 in-memory)

You can run this project either against MySQL (the original setup) or an in-memory H2 database for quick local testing.

Run with MySQL (ensure a database `employee_db` exists and update `src/main/resources/application.properties` with credentials):

```cmd
mvn spring-boot:run -Dspring-boot.run.arguments=--spring.config.location=classpath:/application.properties
```

Run with in-memory H2 (no external DB required):

```cmd
mvn spring-boot:run -Dspring-boot.run.profiles=h2
```

When using H2, open the H2 console at http://localhost:8080/h2-console (JDBC URL: jdbc:h2:mem:employee_db, user: sa).

Build and run jar using H2 profile:

```cmd
mvn -DskipTests package
java -jar target\employee-management-system-0.0.1-SNAPSHOT.jar --spring.profiles.active=h2
```


