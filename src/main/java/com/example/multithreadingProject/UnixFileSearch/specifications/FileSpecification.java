package com.example.multithreadingProject.UnixFileSearch.specifications;

import com.example.multithreadingProject.UnixFileSearch.models.File;

public interface FileSpecification {
    Boolean isSatisfiedBy(File file);

    default FileSpecification and(FileSpecification other) {
        return file -> this.isSatisfiedBy(file) && other.isSatisfiedBy(file);
    }

    default FileSpecification or(FileSpecification other) {
        return file -> this.isSatisfiedBy(file) || other.isSatisfiedBy(file);
    }

    default FileSpecification not() {
        return file -> !this.isSatisfiedBy(file);
    }
}
