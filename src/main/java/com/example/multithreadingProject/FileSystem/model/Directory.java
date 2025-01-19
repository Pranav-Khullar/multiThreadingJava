package com.example.multithreadingProject.FileSystem.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Directory implements FileSystem{
    private final String name;
    private final List<FileSystem> fileSystemList;

    public Directory(String name) {
        this.name = name;
        this.fileSystemList = new ArrayList<>();
    }

    public void addFileSystem(FileSystem fileSystem) {
        fileSystemList.add(fileSystem);
    }

    public void removeFileSystem(FileSystem fileSystem) {
        fileSystemList.remove(fileSystem);
    }

    @Override
    public void ls() {
        System.out.println("Directory name: " + name);
        for(FileSystem fileSystem: fileSystemList) {
            fileSystem.ls();
        }
    }
}
