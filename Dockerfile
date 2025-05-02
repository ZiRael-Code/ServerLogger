FROM maven:3.4.4 as build
COPY . .
RUN mvn -B clean package -DskipTests

FROM openjdk:17-jdk-slim
COPY --from=build ./target/middleware-0.0.1-SNAPSHOT.jar middleware.jar
EXPOSE 7930
ENTRYPOINT ["java","-jar","middleware.jar"]