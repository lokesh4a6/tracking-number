# Define Java here
FROM maven:3.8.5-openjdk-17 AS build


WORKDIR /app

COPY pom.xml .
COPY src ./src

# maven commands
RUN mvn clean package


FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=build /app/target/tracking-number-api-0.0.1-SNAPSHOT.jar tracking-number-api.jar

# exposing the ports for accessing API
EXPOSE 8080


ENTRYPOINT ["java", "-jar", "tracking-number-api.jar"]