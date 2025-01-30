package com.example.multithreadingProject.MessageService.components;

import com.example.multithreadingProject.MessageService.models.SmsMessage;

public class SmsMessageService implements MessageService<SmsMessage> {
    @Override
    public void sendMessage(SmsMessage message) {
        System.out.println("Sending sms to " + message.getRecipient());
    }
}
