package com.example.multithreadingProject.UnixFileSearch;

import com.example.multithreadingProject.UnixFileSearch.models.Directory;
import com.example.multithreadingProject.UnixFileSearch.models.File;
import com.example.multithreadingProject.UnixFileSearch.specifications.ExtensionSpecification;
import com.example.multithreadingProject.UnixFileSearch.specifications.FileSpecification;
import com.example.multithreadingProject.UnixFileSearch.specifications.NameSpecification;
import com.example.multithreadingProject.UnixFileSearch.specifications.SizeSpecification;

import java.util.ArrayList;
import java.util.List;

public class FileSearchApplication {
    public static void main(String[] args) {

        Directory directory = new Directory();
        populateDirectory(directory);

        NameSpecification nameSpecification = new NameSpecification("file3");
        SizeSpecification sizeSpecification = new SizeSpecification(1750L);
        ExtensionSpecification extensionSpecification = new ExtensionSpecification("csv");

        List<FileSpecification> fileSpecifications = new ArrayList<>();
//        fileSpecifications.add(nameSpecification);
        fileSpecifications.add(sizeSpecification);
        fileSpecifications.add(extensionSpecification);

        List<File> result = searchFiles(directory, fileSpecifications);

        // using and, or and not

        FileSpecification compositeSpecification = sizeSpecification.and(extensionSpecification).or(nameSpecification);
        // file either satisfies (sizeSpecification and extensionSpecification) or nameSpecification
        // so this basically chains conditions {[(a&b) | c] & d} and so on
        List<File> result1 = searchFiles(directory, compositeSpecification);

        for(File file: result)  {
            System.out.println(file.toString());
        }

        System.out.println("\nUsing composite specifications ->");
        for(File file: result1) {
            System.out.println(file.toString());
        }
    }

    public static List<File> searchFiles(Directory directory, List<FileSpecification> fileSpecifications) {
        List<File> result = new ArrayList<>();
        for(File file: directory.getFiles()) {
            if (meetsSpecifications(file, fileSpecifications)) result.add(file);
        }

        for(Directory directory1: directory.getDirectories()) {
            result.addAll(searchFiles(directory1, fileSpecifications));
        }

        return result;
    }

    public static List<File> searchFiles(Directory directory, FileSpecification compositeSpecification) {
        List<File> result = new ArrayList<>();
        for(File file: directory.getFiles()) {
            if (compositeSpecification.isSatisfiedBy(file)) result.add(file);
        }

        for(Directory directory1: directory.getDirectories()) {
            result.addAll(searchFiles(directory1, compositeSpecification));
        }

        return result;
    }

    static Boolean meetsSpecifications(File file, List<FileSpecification> fileSpecifications) {
        for(FileSpecification fileSpecification: fileSpecifications) {
            if (!fileSpecification.isSatisfiedBy(file)) return false;
        }
        return true;
    }

    static void populateDirectory(Directory directory) {
        // Sample files
        List<File> files = new ArrayList<>();
        files.add(new File("file1", "txt", 500L));
        files.add(new File("file2", "log", 1500L));
        files.add(new File("file3", "txt", 2000L));
        files.add(new File("file4", "csv", 500L));

        directory.setFiles(files);

        Directory directory1 = new Directory();
        List<File> files1 = new ArrayList<>();
        files1.add(new File("file5", "txt", 500L));
        files1.add(new File("file6", "log", 100L));
        files1.add(new File("file7", "csv", 2000L));
        files1.add(new File("file8", "csv", 1500L));
        directory1.setFiles(files1);

        directory.setDirectories(List.of(directory1));
    }
}
