package com.example.multithreadingProject.MessageService.components;

import com.example.multithreadingProject.MessageService.enums.MessagePriority;
import com.example.multithreadingProject.MessageService.models.Message;

public class MessagePublisher {
    private Producer<String, Message> producer;

    public void publishMessage(Message request) {
        String topic = getPriorityTopic(request.getMessage().getPriority());
        producer.send(new ProducerRecord<>(topic, request.getSystemId(), request));
    }

    private String getPriorityTopic(MessagePriority priority) {
        switch (priority) {
            case HIGH:
                return PriorityTopic.HIGH_PRIORITY_QUEUE.getTopicName();
            case MEDIUM:
                return PriorityTopic.MEDIUM_PRIORITY_QUEUE.getTopicName();
            case LOW:
                return PriorityTopic.LOW_PRIORITY_QUEUE.getTopicName();
            default:
                throw new IllegalArgumentException("Invalid priority");
        }
    }
}
