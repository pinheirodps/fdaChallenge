# Use an official OpenJDK runtime as the base image
FROM openjdk:17-jdk-alpine
  
  # Add the JAR file to the container
COPY target/*.jar app.jar
  
  # Expose the port that the application runs on
EXPOSE 8080
  
  # Run the application
CMD ["java", "-jar", "app.jar"]
