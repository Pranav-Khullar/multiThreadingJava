package com.example.multithreadingProject.MessageService.components;

import com.example.multithreadingProject.MessageService.models.MessageRequest;
import com.example.multithreadingProject.MessageService.models.SmsMessage;
import com.example.multithreadingProject.MessageService.models.Template;

import java.util.Map;

public class SmsMessageCreator implements MessageCreator<SmsMessage> {

    @Override
    public SmsMessage createMessage(Template template, MessageRequest messageRequest) {
        return new SmsMessage();
    }
}
