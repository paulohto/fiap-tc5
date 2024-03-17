FROM openjdk:21-alpine

EXPOSE 8082

WORKDIR /app

ENV SPRING_SERVER_PORT=8082
ENV SPRING_DATA_SOURCE_URL=postgresql://localhost:5432/api_cart_db
ENV SPRING_DATA_SOURCE_USERNAME=admin
ENV SPRING_DATA_SOURCE_PASSWORD=admin

COPY .mvn/ .mvn/
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src

CMD [ "./mvnw", "spring-boot:run"]