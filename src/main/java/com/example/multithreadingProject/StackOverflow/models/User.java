package com.example.multithreadingProject.StackOverflow.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final int id;
    private final String userName;
    private final String email;
    private int reputation;
    private final List<Comment> comments;
    private final List<Question> questions;
    private final List<Answer> answers;

    public User(int id, String userName, String email) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        reputation = 0;
        comments = new ArrayList<>();
        questions = new ArrayList<>();
        answers = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public Question askQuestion(String title, String content, List<String> tags) {
        Question question = new Question(this, title, content, tags);
        questions.add(question);
        updateReputation(Reputation.QUESTION_REPUTATION);
        return question;
    }

    public Answer answerQuestion(Question question, String content) {
        Answer answer = new Answer(this, content, question);
        answers.add(answer);
        question.addAnswer(answer);
        updateReputation(Reputation.ANSWER_REPUTATION);
        return answer;
    }

    public Comment addComment(Commentable commentable, String content) {
        Comment comment = new Comment(this, content);
        comments.add(comment);
        commentable.addComment(comment);
        updateReputation(Reputation.COMMENT_REPUTATION);
        return comment;
    }

    public synchronized void updateReputation(int value) {
        reputation += value;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public List<Answer> getAnswers() {
        return answers;
    }
}
