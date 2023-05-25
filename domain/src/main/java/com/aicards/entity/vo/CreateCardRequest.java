package com.aicards.entity.vo;

import java.util.List;

public class CreateCardRequest {
    private String userId;
    private List<QuestionsRequest> questions;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<QuestionsRequest> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionsRequest> questions) {
        this.questions = questions;
    }
}
