FROM maven:3.8.8-eclipse-temurin-17 AS builder

WORKDIR /usr/src/app

COPY . /usr/src/app
RUN mvn package

FROM eclipse-temurin:17.0.9_9-jre

COPY --from=builder /usr/src/app/target/*.jar /app.jar

EXPOSE 8080

ENTRYPOINT ["java"]
CMD ["-jar", "/app.jar"]
