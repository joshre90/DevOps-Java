FROM openjdk:latest

WORKDIR /app/

COPY build/libs/farm-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]

