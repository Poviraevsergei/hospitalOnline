FROM openjdk:11
RUN mkdir /app
WORKDIR /app
COPY target/hospitalOnline-0.0.1-SNAPSHOT.jar /app
ENTRYPOINT java -jar /app/hospitalOnline-0.0.1-SNAPSHOT.jar