# Use Eclipse Temurin JDK 22 as base image
FROM eclipse-temurin:22-jdk

# Set working directory
WORKDIR /app

# Copy the built jar file
COPY target/RestServices-*.jar app.jar

# Expose default Spring Boot port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]