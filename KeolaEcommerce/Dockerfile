
FROM maven:3.8-openjdk-17 AS build
WORKDIR /app
COPY pom.xml ./
RUN mvn dependency:go-offline

COPY src ./src

RUN mvn clean package -DskipTests -e

FROM openjdk:17-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar /app/keola-ecommerce.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/keola-ecommerce.jar"]
