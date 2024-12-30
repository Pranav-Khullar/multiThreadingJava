package com.example.multithreadingProject.UnixFileSearch.specifications;

import com.example.multithreadingProject.UnixFileSearch.models.File;

public class ExtensionSpecification implements FileSpecification{

    private final String extension;

    public ExtensionSpecification(String extension) {
        this.extension = extension;
    }

    @Override
    public Boolean isSatisfiedBy(File file) {
        return file.getExtension().equalsIgnoreCase(extension);
    }
}
