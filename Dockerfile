FROM adoptopenjdk/openjdk8:alpine-slim
ADD target/exchange-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8103
EXPOSE 27017
ENTRYPOINT ["java", "-jar","/app.jar"]