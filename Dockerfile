# Multi-stage Dockerfile for Spring Boot application
# Stage 1: Build stage using Maven
FROM maven:3.9-eclipse-temurin-25 AS builder

WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests -B

# Stage 2: Runtime stage using lightweight JRE
FROM eclipse-temurin:25-jre

# Build arguments for image metadata
ARG BUILD_DATE
ARG VCS_REF
ARG VERSION=0.0.1-SNAPSHOT

# Labels for image metadata
LABEL org.opencontainers.image.created="${BUILD_DATE}"
LABEL org.opencontainers.image.revision="${VCS_REF}"
LABEL org.opencontainers.image.version="${VERSION}"
LABEL org.opencontainers.image.title="Spring-craft"
LABEL org.opencontainers.image.description="Spring Boot application with observable pattern and payment strategies"
LABEL org.opencontainers.image.vendor="Amos"

WORKDIR /app

# Copy JAR from builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose port 8080
EXPOSE 8080

# Health check
HEALTHCHECK --interval=30s --timeout=3s --start-period=5s --retries=3 \
    CMD java -cp app.jar org.springframework.boot.loader.JarLauncher || exit 1

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]

