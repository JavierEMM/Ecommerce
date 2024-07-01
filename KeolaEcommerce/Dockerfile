FROM openjdk:17-jdk-alpine AS build
WORKDIR /app
COPY . /app
RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/keola-ecommerce-0.0.1-SNAPSHOT.jar /app/keola-ecommerce.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/keola-ecommerce.jar"]