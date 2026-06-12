#use the officail OpenJDK 25 image from docker hub as the base image
FROM eclipse-temurin:25-jre

#Set working directory in the container to /app
WORKDIR /app

#Copy the compiled jar file from the target directory of the host machine to the /app directory in the container
COPY  ./target/post-image-0.0.1-SNAPSHOT /app

#Expose port 8080 to allow external access to the application running inside the container
EXPOSE 8080

#Command to run the application when the container starts. It executes the jar file using java -jar command
CMD ["java", "-jar", "post-image-0.0.1-SNAPSHOT"]