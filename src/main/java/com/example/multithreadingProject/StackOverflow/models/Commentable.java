package com.example.multithreadingProject.StackOverflow.models;

import java.util.ArrayList;
import java.util.List;

public interface Commentable {
    void addComment(Comment comment);
    List<Comment> getComments();
}
