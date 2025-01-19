package com.example.multithreadingProject.StudentBuilder.model;

import lombok.Getter;

@Getter
public class StudentBuilder {
    private final int rollNumber; // for required fields make them final
    private String name;
    private String fatherName;
    private String motherName;

    public StudentBuilder(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public StudentBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public StudentBuilder setFatherName(String name) {
        this.fatherName = name;
        return this;
    }

    public StudentBuilder setMotherName(String name) {
        this.motherName = name;
        return this;
    }

    public Student build() {
        return new Student(this);
    }
}
