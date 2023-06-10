FROM ubuntu:20.04

RUN apt update
RUN apt upgrade -y
RUN apt install default-jdk -y
RUN apt install wget -y
RUN apt install screen -y
RUN apt install iproute2 -y
RUN apt install nano -y
RUN apt install iputils-ping -y

WORKDIR /app

COPY kafka_2.13-3.4.0 .

CMD ["bash"]
