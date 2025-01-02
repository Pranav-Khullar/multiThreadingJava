package com.example.multithreadingProject.StackOverflow.models;

import java.util.concurrent.atomic.AtomicInteger;

public class Tag {
    private final int id;
    private final String value;
    private AtomicInteger tagId = new AtomicInteger(1);

    public Tag(String value) {
        this.id = tagId.getAndIncrement();
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}
