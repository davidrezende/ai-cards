package com.aicards.entity.vo;

public class PromptRequest {

    private String model;
    private String prompt;
    private Integer temperature;
    private Integer max_tokens;
    private Integer top_p;
    private Integer frequency_penalty;
    private Integer presence_penalty;

    public PromptRequest(String model, String prompt, Integer temperature, Integer max_tokens, Integer top_p, Integer frequency_penalty, Integer presence_penalty) {
        this.model = model;
        this.prompt = prompt;
        this.temperature = temperature;
        this.max_tokens = max_tokens;
        this.top_p = top_p;
        this.frequency_penalty = frequency_penalty;
        this.presence_penalty = presence_penalty;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getMax_tokens() {
        return max_tokens;
    }

    public void setMax_tokens(Integer max_tokens) {
        this.max_tokens = max_tokens;
    }

    public Integer getTop_p() {
        return top_p;
    }

    public void setTop_p(Integer top_p) {
        this.top_p = top_p;
    }

    public Integer getFrequency_penalty() {
        return frequency_penalty;
    }

    public void setFrequency_penalty(Integer frequency_penalty) {
        this.frequency_penalty = frequency_penalty;
    }

    public Integer getPresence_penalty() {
        return presence_penalty;
    }

    public void setPresence_penalty(Integer presence_penalty) {
        this.presence_penalty = presence_penalty;
    }
}
