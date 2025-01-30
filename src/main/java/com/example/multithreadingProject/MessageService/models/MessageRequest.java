package com.example.multithreadingProject.MessageService.models;

import com.example.multithreadingProject.MessageService.enums.CommunicationType;
import com.example.multithreadingProject.MessageService.enums.MessageType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class MessageRequest {
    private Map<String, String> values;
    private List<CommunicationType> communicationTypeList;
    private MessageType messageType;
    private String Recipient;
}
