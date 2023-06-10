FROM ubuntu:latest

RUN apt-get update && \
    apt-get install openjdk-18-jdk -y
RUN apt-get upgrade -y
RUN apt-get install maven -y

WORKDIR /app

COPY kafka-project-3/ kafka-project-3/

RUN cd kafka-project-3 && mvn clean package

# CMD ["java", "-jar", "/kafka-project-3/target/kafka-project-3-1.0-SNAPSHOT.jar"]

