# ======== Instructions ======== #


0. Download kafka from 
and change config/server.properties value for zookeeper.connect=localhost:2181 to 172.18.0.2:2181 

1. Create a container with zookeeper (ip:172.18.0.2), another with a broker (ip:172.18.0.3) and another one that creates a topic (and immediately gets killed)
- cd server
- docker build -t kafka-server .
- docker compose up

2. Create a container wita a producer
- cd producer
- docker build -t kafka-producer .
- docker run -it --name producer --network kafka-network kafka-producer

3. Create a container wita a consumer
- cd consumer
- docker build -t kafka-consumer .
- docker run -t --name consumer --network kafka-network kafka-consumer


As a reminder from kafka documentation:
 
Run the following commands in order to start all services in the correct order: 

# Start the ZooKeeper service
$ bin/zookeeper-server-start.sh config/zookeeper.properties

Open another terminal session and run:

# Start the Kafka broker service
$ bin/kafka-server-start.sh config/server.properties

 So before you can write your first events, you must create a topic. Open another terminal session and run:
$ bin/kafka-topics.sh --create --topic quickstart-events --bootstrap-server localhost:9092
