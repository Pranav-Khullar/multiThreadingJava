package com.example.multithreadingProject.MessageService.components;

import com.example.multithreadingProject.MessageService.models.EmailMessage;

public class EmailMessageService implements MessageService<EmailMessage>{

    @Override
    public void sendMessage(EmailMessage message) {
        System.out.println("Sending email to: " + message.getRecipient());
    }
}
