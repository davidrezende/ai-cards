package com.aicards.entity;

import java.time.LocalDate;

public class QuestionEntity {

    private String questionId;
    private LocalDate datCreation;
    private String question;

    public QuestionEntity(String questionId, LocalDate datCreation, String question) {
        this.questionId = questionId;
        this.datCreation = datCreation;
        this.question = question;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public LocalDate getDatCreation() {
        return datCreation;
    }

    public void setDatCreation(LocalDate datCreation) {
        this.datCreation = datCreation;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
