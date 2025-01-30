package com.example.multithreadingProject.MessageService.components;

import com.example.multithreadingProject.MessageService.enums.CommunicationType;
import com.example.multithreadingProject.MessageService.models.Message;
import com.example.multithreadingProject.MessageService.models.MessageRequest;
import com.example.multithreadingProject.MessageService.models.Template;

import java.util.ArrayList;
import java.util.List;

public class MessageProcessor<T extends Message> {
    private MessageCreatorFactory messageCreatorFactory;
    private MessagePublisher messagePublisher;

    public void processMessageAndPublish(MessageRequest messageRequest) {
        List<T> messages = processMessage(messageRequest);
        for(T message: messages) {
            messagePublisher.publishMessage(message);
        }
    }

    private List<T> processMessage(MessageRequest messageRequest) {
        Template template = new Template();
        List<T> messageList = new ArrayList<>();
        for(CommunicationType communicationType: messageRequest.getCommunicationTypeList()) {
            messageList.add((T) messageCreatorFactory.getMessageCreator(communicationType).createMessage(template, messageRequest));
        }

        return messageList;
    }
}
