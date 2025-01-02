package com.example.multithreadingProject.StackOverflow.models;

import java.time.LocalDateTime;

public interface Content {
    Integer getId();
    String getContent();
    User getAuthor();
    LocalDateTime getCreationTime();
}
