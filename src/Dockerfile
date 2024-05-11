# Use a base image with Maven and JDK 17
FROM maven:3.8.4-openjdk-17 AS build

# Copy the Maven project file
COPY pom.xml .

# Build all dependencies for caching
RUN mvn dependency:go-offline -B

# Copy the source code
COPY src ./src

# Build the application
RUN mvn package -DskipTests

# Use a base image with Java 17
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the packaged JAR file from the build stage to the working directory in the container
COPY --from=build /target/ContactFormApplication.jar /app/app.jar

# Expose the port the application runs on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]
