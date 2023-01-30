FROM openjdk:17-alpine
EXPOSE 9092
ADD target/movie-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]