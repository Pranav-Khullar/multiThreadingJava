package com.example.multithreadingProject.MessageService.components;

import com.example.multithreadingProject.MessageService.models.Message;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class MessageConsumer {
    private KafkaConsumer<String, Message> consumer;
    private MessageServiceFactory messageServiceFactory;

    public MessageConsumer(String groupId, String topic) {
        // Initialize Kafka consumer
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", groupId);
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "com.example.MessageRequestDeserializer");
        consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Collections.singletonList(topic));
    }

    public void consumeMessages() {
        while (true) {
            ConsumerRecords<String, Message> records = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String, Message> record : records) {
                Message request = record.value();
                sendMessage(request);
            }
        }
    }

    private void sendMessage(Message request) {
        // Process the message (e.g., send email/SMS)
        System.out.println("Sending message: " + request);
        messageServiceFactory.getMessageService(request).sendMessage(request);
    }
}
