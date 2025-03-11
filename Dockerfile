# Step 1: Build the application
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Build the application (adjust if using Gradle)
RUN mvn clean package -DskipTests

# Step 2: Run the application with a smaller JDK image
FROM eclipse-temurin:17-jre

# Set working directory
WORKDIR /app

# Copy the built JAR from the previous stage
COPY --from=build /app/target/*.jar app.jar

# Expose application port
EXPOSE 7001

# Run the application
CMD ["java", "-jar", "app.jar"]
