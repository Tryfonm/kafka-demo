from kafka import KafkaProducer

TOPIC_NAME = "python_topic_test"
BOOTSTRAP_SERVERS = "172.18.0.3:9092"

producer = KafkaProducer(bootstrap_servers=BOOTSTRAP_SERVERS)


while True:
  try:
    msg = input("Enter message: ").encode("utf-8")
    producer.send(TOPIC_NAME, msg)
    producer.flush()
  except KeyboardInterrupt:
    print("\n\nStopping producer...\n")
    break
