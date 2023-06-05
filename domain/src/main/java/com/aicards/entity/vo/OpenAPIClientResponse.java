package com.aicards.entity.vo;

import java.util.List;

public class OpenAPIClientResponse {
    private List<ChoiceVO> choices;

    public OpenAPIClientResponse(List<ChoiceVO> choices) {
        this.choices = choices;
    }

    public OpenAPIClientResponse() {
    }

    public List<ChoiceVO> getChoices() {
        return choices;
    }

    public void setChoices(List<ChoiceVO> choices) {
        this.choices = choices;
    }
}
