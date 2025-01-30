package com.example.multithreadingProject.MessageService.components;

public interface MessageService<T> {
    void sendMessage(T message);
}
