package com.aicards.entity.vo;

import java.util.List;

public class OpenAIClientResponse {
    private List<ChoiceVO> choices;

    public OpenAIClientResponse(List<ChoiceVO> choices) {
        this.choices = choices;
    }

    public OpenAIClientResponse() {
    }

    public List<ChoiceVO> getChoices() {
        return choices;
    }

    public void setChoices(List<ChoiceVO> choices) {
        this.choices = choices;
    }
}
