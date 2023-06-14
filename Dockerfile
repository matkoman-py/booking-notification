FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/booking-notification-0.0.1-SNAPSHOT.jar booking-notification-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "booking-notification-0.0.1-SNAPSHOT.jar"]