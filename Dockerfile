# Use a lightweight Java 17 runtime
FROM eclipse-temurin:21-jdk AS build

# Create app directory
WORKDIR /app

# Copy everything (including Maven wrapper if using it)
COPY . .

# Make the Maven wrapper script executable
RUN chmod +x mvnw

# Build the app (change this if you use Gradle)
RUN ./mvnw clean package -DskipTests

# --- Final image ---
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy the built JAR from the builder stage
COPY --from=build /app/target/*.jar app.jar

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]