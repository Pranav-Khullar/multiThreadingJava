package com.example.multithreadingProject.MessageService.components;

import com.example.multithreadingProject.MessageService.enums.CommunicationType;

public class MessageCreatorFactory {
    private SmsMessageCreator smsMessageCreator;

    public MessageCreator getMessageCreator(CommunicationType communicationType) {
        if (communicationType == CommunicationType.SMS) return smsMessageCreator;
        else {
            throw new RuntimeException();
        }
    }
}
