# Docker Setup for Spring-craft

This guide explains how to build and run the Spring-craft application using Docker.

## Prerequisites

- Docker (version 20.10+)
- Docker Compose (version 1.29+)
- Git

## Quick Start with Docker Compose

The easiest way to run the application is using Docker Compose:

```bash
# Build and start the container
docker-compose up -d

# View logs
docker-compose logs -f spring-craft

# Stop the container
docker-compose down
```

The application will be available at `http://localhost:8080`

## Manual Docker Build and Run

### Build the Docker Image

```bash
# Build the image with multi-stage build
docker build -t spring-craft:latest .

# Verify the image was created
docker images | grep spring-craft
```

### Run the Container

```bash
# Run the container
docker run -d \
  --name spring-craft-app \
  -p 8080:8080 \
  -e JAVA_OPTS="-Xms256m -Xmx512m" \
  spring-craft:latest

# View logs
docker logs -f spring-craft-app

# Stop the container
docker stop spring-craft-app

# Remove the container
docker rm spring-craft-app
```

## Configuration

### Environment Variables

You can customize the application behavior using environment variables:

- `SPRING_APPLICATION_NAME`: Application name (default: Spring-craft)
- `SERVER_PORT`: Server port (default: 8080)
- `JAVA_OPTS`: JVM options (default: -Xms256m -Xmx512m)

### Port Mapping

The application runs on port `8080` inside the container. You can map it to a different host port:

```bash
docker run -p 9090:8080 spring-craft:latest
# Access via http://localhost:9090
```

## Health Check

The container includes a health check that monitors the application's readiness. Check the status:

```bash
docker ps --filter "name=spring-craft"
# Status will show: Up X seconds (healthy) or (unhealthy)
```

## Troubleshooting

### Container fails to start

```bash
# Check logs for errors
docker logs spring-craft-app

# Verify the image has a valid JAR
docker run -it spring-craft:latest ls -la /app/
```

### Port already in use

```bash
# Use a different port
docker run -p 9090:8080 spring-craft:latest

# Or stop existing containers
docker-compose down
```

### Memory issues

Adjust the `JAVA_OPTS` environment variable:

```bash
docker run -e JAVA_OPTS="-Xms512m -Xmx1024m" spring-craft:latest
```

## Docker Image Details

- **Base Image (build)**: `maven:3.9-eclipse-temurin-25` - Maven with Java 25
- **Base Image (runtime)**: `eclipse-temurin:25-jre` - Lightweight Java 25 JRE
- **Working Directory**: `/app`
- **Exposed Port**: `8080`
- **Default Heap**: 256MB min, 512MB max

## Multi-stage Build Benefits

The Dockerfile uses a two-stage build:

1. **Builder Stage**: Compiles source code with Maven (produces large intermediate image)
2. **Runtime Stage**: Runs the JAR on lightweight JRE (final image is smaller)

This approach reduces final image size and improves security by excluding build tools from the runtime image.

## Network Access

The application makes external API calls to `https://api.restful-api.dev`. Ensure:

- Docker has internet access (default)
- Firewall allows outbound HTTPS (port 443)
- DNS resolution is working inside the container

## Pushing to Docker Hub (Optional)

To share your image on Docker Hub:

```bash
# Tag the image
docker tag spring-craft:latest your-username/spring-craft:latest

# Login to Docker Hub
docker login

# Push the image
docker push your-username/spring-craft:latest

# Pull from Docker Hub
docker pull your-username/spring-craft:latest
```

## Production Considerations

For production deployments:

1. Use specific version tags instead of `latest`
2. Implement proper logging and monitoring
3. Use secrets management for sensitive data
4. Configure appropriate JVM memory settings based on your infrastructure
5. Set up container orchestration (Kubernetes, Docker Swarm)
6. Use private Docker registry for security
7. Implement CI/CD pipeline to automate builds

## License

Same as the main Spring-craft project.

