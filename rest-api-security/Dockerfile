FROM openjdk:16-alpine3.13

WORKDIR /app

COPY target/rest-api-security*.jar app/rest-api-security*.jar

ENTRYPOINT java -jar app/rest-api-security*.jar