package com.example.multithreadingProject.UnixFileSearch.specifications;

import com.example.multithreadingProject.UnixFileSearch.models.File;

public class NameSpecification implements FileSpecification{

    private final String name;

    public NameSpecification(String name) {
        this.name = name;
    }

    @Override
    public Boolean isSatisfiedBy(File file) {
        return file.getName().equalsIgnoreCase(name);
    }
}
