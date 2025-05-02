FROM maven:3.9.9 as build
COPY . .
RUN mvn -B clean package -DskipTests

FROM openjdk:17-jdk-slim
COPY --from=build ./target/ServerLogger-0.0.1-SNAPSHOT.jar ServerLogger.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","ServerLogger.jar"]