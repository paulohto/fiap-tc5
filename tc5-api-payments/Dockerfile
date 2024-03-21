FROM openjdk:21-alpine

EXPOSE 8083

WORKDIR /app

ENV SPRING_SERVER_PORT=8080
ENV SPRING_DATA_SOURCE_URL=jdbc:postgresql://localhost:5434/api_carts_db
ENV SPRING_DATA_SOURCE_USERNAME=admin
ENV SPRING_DATA_SOURCE_PASSWORD=admin
ENV SPRING_JWT_SECRET="batman batman batman"
ENV SPRING_URL_PRODUCT=http://localhost:8082

COPY .mvn/ .mvn/
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src

CMD [ "./mvnw", "spring-boot:run"]