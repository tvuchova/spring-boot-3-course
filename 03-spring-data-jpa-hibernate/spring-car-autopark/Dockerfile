# Use a base image with Java 21
FROM openjdk:21
# Copy the JAR package into the image
ARG JAR_FILE=build/libs/spring-car-autopark.jar
COPY ${JAR_FILE} autopark.jar
# Expose the application port
EXPOSE 8090
# Run the application
ENTRYPOINT ["java", "-jar", "/autopark.jar"]
