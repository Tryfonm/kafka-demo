package org.example;

import org.apache.kafka.clients.producer.*;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {

        Logger.getLogger("org.apache.kafka").setLevel(Level.OFF);
        String bootstrapServers = "172.18.0.3:9092";

        String topic = "python_topic_test";

        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Prompt the user for input
            System.out.print("Enter input (or 'exit' to quit): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break; // Exit the loop if user enters 'exit'
            }

            ProducerRecord<String, String> record = new ProducerRecord<>(topic, input);

            // Send the record asynchronously
            producer.send(record, new Callback() {
                @Override
                public void onCompletion(RecordMetadata metadata, Exception exception) {
                    if (exception == null) {
                        System.out.println("Message sent successfully! Topic: " + metadata.topic() +
                                ", Partition: " + metadata.partition() +
                                ", Offset: " + metadata.offset());
                    } else {
                        System.err.println("Error while sending message: " + exception.getMessage());
                    }
                }
            });
        }

        // Flush and close the producer
        producer.flush();
        producer.close();

        // Close the scanner
        scanner.close();
    }
}
