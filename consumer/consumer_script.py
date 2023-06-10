from kafka import KafkaConsumer

TOPIC_NAME = "python_topic_test"
BOOTSTRAP_SERVERS = "172.18.0.3:9092"

consumer = KafkaConsumer(TOPIC_NAME, bootstrap_servers=BOOTSTRAP_SERVERS)

for message in consumer:
    print(message)
