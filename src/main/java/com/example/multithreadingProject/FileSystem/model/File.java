package com.example.multithreadingProject.FileSystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class File implements FileSystem{
    private final String name;

    @Override
    public void ls() {
        System.out.println("File name: " + name);
    }
}
