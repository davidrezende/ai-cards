package com.aicards.dataprovider.model;

import com.aicards.entity.QuestionEntity;

import java.time.LocalDate;

public class Question {

    private String questionId;
    private LocalDate datCreation;
    private String question;

    public Question(String questionId, LocalDate datCreation, String question) {
        this.questionId = questionId;
        this.datCreation = datCreation;
        this.question = question;
    }

    public Question() {
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

    public Question toQuestion(QuestionEntity entity) {
        return new Question(
                entity.getQuestionId(),
                entity.getDatCreation(),
                entity.getQuestion()
        );
    }

    public QuestionEntity toEntity() {
        return new QuestionEntity(
                this.questionId,
                this.datCreation,
                this.question
        );
    }
}
