FROM ubuntu:latest

RUN apt-get update && apt-get install -y netcat

WORKDIR /app

COPY socket_listener.sh /app/socket_listener.sh
RUN chmod +x /app/socket_listener.sh

CMD ["/app/socket_listener.sh"]
