package com.example.multithreadingProject.UnixFileSearch.specifications;

import com.example.multithreadingProject.UnixFileSearch.models.File;

public class SizeSpecification implements FileSpecification{

    private final Long size;

    public SizeSpecification(Long size) {
        this.size = size;
    }

    @Override
    public Boolean isSatisfiedBy(File file) {
        return file.getSize() <= size;
    }
}
