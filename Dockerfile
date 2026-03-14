# Use Java 21 JDK base image
FROM eclipse-temurin:21-jdk-alpine

# Set working directory
WORKDIR /app

# Copy Maven wrapper and pom.xml first (for caching)
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Copy source code
COPY src ./src

# Build the project
RUN ./mvnw clean package -DskipTests

# Expose the port Render provides
ENV PORT=8080
EXPOSE $PORT

# Start Spring Boot app
ENTRYPOINT ["java","-jar","target/catcafe-0.0.1-SNAPSHOT.jar"]
