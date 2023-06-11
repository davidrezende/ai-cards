package com.aicards.entity.vo;

public class ReplicateAIResponse {

    private String output;
    private String id;

    public ReplicateAIResponse(String output, String id) {
        this.output = output;
        this.id = id;
    }

    public ReplicateAIResponse() {
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
