FROM openjdk:11

WORKDIR /app

COPY . /app

RUN apt-get update && apt-get install -y maven

RUN mvn clean install

CMD ["java", "-jar", "target/Biblioteca-1.0-SNAPSHOT.jar"]