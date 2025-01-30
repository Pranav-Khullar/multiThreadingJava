package com.example.multithreadingProject.MessageService.components;

import com.example.multithreadingProject.MessageService.models.MessageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessagingAPI {
    private MessageProcessor messageProcessor;

    @PostMapping
    public ResponseEntity<String> sendMessage(MessageRequest messageRequest) {
        messageProcessor.processMessageAndPublish(messageRequest);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
