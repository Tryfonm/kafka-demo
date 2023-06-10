FROM ubuntu:20.04

RUN apt update
RUN apt upgrade -y
# RUN apt install default-jdk -y
# RUN apt install wget -y
RUN apt install screen -y
RUN apt install iproute2 -y
RUN apt install nano -y
RUN apt install iputils-ping -y
RUN apt install python3-pip -y

WORKDIR /app

COPY consumer_script.py requirements.txt .

RUN pip3 install -r requirements.txt

ENTRYPOINT ["python3", "consumer_script.py"]
