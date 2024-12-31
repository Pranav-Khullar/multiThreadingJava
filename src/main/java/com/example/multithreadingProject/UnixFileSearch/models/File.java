package com.example.multithreadingProject.UnixFileSearch.models;

public class File {
    String extension;
    String name;
    Long size;

    public File(String name, String extension, Long size) {
        this.name = name;
        this.extension = extension;
        this.size = size;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "File{name='" + name + "', extension='" + extension + "', size=" + size + '}';
    }
}
