FROM maven:3.8.1-openjdk-17-slim AS builder
WORKDIR /app
COPY app .
RUN mvn -e -B dependency:resolve
RUN mvn clean -e -B package

FROM openjdk:17
WORKDIR /app
COPY --from=builder /app/target/*.jar /app/*.jar
EXPOSE 8088
ENTRYPOINT ["java", "-jar", "/app/*.jar" ]
