package com.example.multithreadingProject.MessageService.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailMessage extends Message{
    private String subject;
    private String urlAttachment;
}
