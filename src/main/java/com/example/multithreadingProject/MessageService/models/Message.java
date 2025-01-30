package com.example.multithreadingProject.MessageService.models;

import com.example.multithreadingProject.MessageService.enums.MessagePriority;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Message {
    private String content;
    private String recipient;
    private MessagePriority priority;
}
