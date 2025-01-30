package com.example.multithreadingProject.MessageService.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SmsMessage extends Message{
    private String senderId;
}
