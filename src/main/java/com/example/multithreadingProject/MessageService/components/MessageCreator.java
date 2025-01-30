package com.example.multithreadingProject.MessageService.components;

import com.example.multithreadingProject.MessageService.models.Message;
import com.example.multithreadingProject.MessageService.models.MessageRequest;
import com.example.multithreadingProject.MessageService.models.Template;


public interface MessageCreator<T extends Message> {
    T createMessage(Template template, MessageRequest messageRequest);
}
