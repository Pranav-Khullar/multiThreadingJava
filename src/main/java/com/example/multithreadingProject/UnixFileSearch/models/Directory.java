package com.example.multithreadingProject.UnixFileSearch.models;

import java.util.ArrayList;
import java.util.List;

public class Directory {
    List<Directory> directories = new ArrayList<>();
    List<File> files = new ArrayList<>();

    public List<Directory> getDirectories() {
        return directories;
    }

    public void setDirectories(List<Directory> directories) {
        this.directories = directories;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }
}
