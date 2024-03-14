FROM openjdk:21-alpine

EXPOSE 8080

WORKDIR /app

ENV SPRING_SERVER_PORT=8080
ENV SPRING_DATA_SOURCE_URL=mongodb
ENV SPRING_DATA_SOURCE_USERNAME=mongodb://root:example@localhost:27017/
ENV SPRING_DATA_SOURCE_PASSWORD=mongodb://root:example@localhost:27017/

COPY .mvn/ .mvn/
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src

CMD [ "./mvnw", "spring-boot:run"]