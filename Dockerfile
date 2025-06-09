FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21
WORKDIR /app
COPY --from=build /app/core/target/*.jar financial-app.jar
EXPOSE 8484
ENTRYPOINT ["java", "-jar", "financial-app.jar"]