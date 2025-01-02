package com.example.multithreadingProject.StackOverflow.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Answer implements Votable, Commentable, Content{

    private final int id;
    private final User author;
    private final String content;
    private final LocalDateTime dateCreated;
    private final Question question;
    private Boolean isAccepted;
    private final List<Comment> comments;
    private final Map<Integer, Vote> votes;
    private AtomicInteger answerId = new AtomicInteger(1);
    private Integer voteCount = 0;

    public Answer(User author, String content, Question question) {
        id = answerId.getAndIncrement();
        this.author = author;
        this.content = content;
        this.dateCreated = LocalDateTime.now();
        this.question = question;
        comments = new ArrayList<>();
        votes = new HashMap<>();
    }


    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public List<Comment> getComments() {
        return comments;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public User getAuthor() {
        return author;
    }

    @Override
    public LocalDateTime getCreationTime() {
        return dateCreated;
    }

    @Override
    public void vote(User user, int value) {
        if (value != 1 && value != -1) {
            throw new IllegalArgumentException();
        }
        Vote vote = new Vote(user, value);
        if (votes.containsKey(user.getId())) {
            voteCount -= votes.get(user.getId()).getValue();
        }
        votes.put(user.getId(), vote);
        voteCount += value;
        user.updateReputation(Reputation.QUESTION_REPUTATION);
        author.updateReputation(value * 5);
    }

    @Override
    public int getVoteCount() {
        return voteCount;
    }

    public void markAccepted() {
        this.isAccepted  = true;
    }

    public Boolean isAccepted() {
        return isAccepted;
    }
}
