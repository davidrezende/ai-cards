package com.aicards.entity.vo;

import java.util.List;

public class ReplicateAIResponse {

    private List<String> output;
    private String id;
    private String status;

    public ReplicateAIResponse() {
    }

    public ReplicateAIResponse(List<String> output, String id, String status) {
        this.output = output;
        this.id = id;
        this.status = status;
    }

    public List<String> getOutput() {
        return output;
    }

    public void setOutput(List<String> output) {
        this.output = output;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
