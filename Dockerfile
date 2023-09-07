FROM maven:3.8.5-openjdk-17-slim AS MAVEN_BUILD
COPY ./ ./
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=MAVEN_BUILD /target/booking-notification-0.0.1-SNAPSHOT.jar /booking-notification.jar
EXPOSE 8083
CMD ["java", "-jar", "/booking-notification.jar"]