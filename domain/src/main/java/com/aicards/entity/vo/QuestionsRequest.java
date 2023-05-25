package com.aicards.entity.vo;

public class QuestionsRequest {
    private String questionId;
    private String answer;

    public QuestionsRequest(String questionId, String answer) {
        this.questionId = questionId;
        this.answer = answer;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
