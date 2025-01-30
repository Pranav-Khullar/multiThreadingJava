package com.example.multithreadingProject.MessageService.components;

import com.example.multithreadingProject.MessageService.models.EmailMessage;
import com.example.multithreadingProject.MessageService.models.Message;
import com.example.multithreadingProject.MessageService.models.SmsMessage;

public class MessageServiceFactory {
    private SmsMessageService smsMessageService;
    private EmailMessageService emailMessageService;

    public MessageService getMessageService(Message message) {
        if (message instanceof SmsMessage) return smsMessageService;
        else if (message instanceof EmailMessage) return emailMessageService;
        else throw new RuntimeException();
    }
}
