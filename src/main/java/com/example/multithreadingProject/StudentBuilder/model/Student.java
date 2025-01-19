package com.example.multithreadingProject.StudentBuilder.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Student {
    private int rollNumber;
    private String name;
    private String fatherName;
    private String motherName;

    public Student(StudentBuilder studentBuilder) {
        this.rollNumber = studentBuilder.getRollNumber();
        this.name = studentBuilder.getName();
        this.fatherName = studentBuilder.getFatherName();
        this.motherName = studentBuilder.getMotherName();
    }

}
