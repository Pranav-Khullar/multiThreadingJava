package com.example.multithreadingProject.StackOverflow.models;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Question implements Content, Commentable, Votable{

    private final int id;
    private final User author;
    private final String title;
    private final String content;
    private final LocalDateTime dateCreated;
    private final List<Answer> answers;
    private final List<Comment> comments;
    private final Map<Integer, Vote> votes;
    private final List<Tag> tags;
    private Integer voteCount = 0;
    private AtomicInteger questionId = new AtomicInteger(1);

    public Question(User author, String title, String content, List<String> tags) {
        this.id = questionId.getAndIncrement();
        this.author = author;
        this.title = title;
        this.content = content;
        this.dateCreated = LocalDateTime.now();
        this.answers = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.votes = new HashMap<>();
        this.tags = new ArrayList<>();
        for(String tag: tags) {
            this.tags.add(new Tag(tag));
        }
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

    public List<Tag> getTags() {
        return tags;
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public Map<Integer, Vote> getVotes() {
        return votes;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }
}
