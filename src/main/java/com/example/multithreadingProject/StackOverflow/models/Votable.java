package com.example.multithreadingProject.StackOverflow.models;

public interface Votable {
    void vote(User user, int value);
    int getVoteCount();
}
