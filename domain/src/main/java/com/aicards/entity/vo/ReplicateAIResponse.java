package com.aicards.entity.vo;

import java.util.List;

public class ReplicateAIResponse {

    private List<String> output;
    private String id;
    private String status;
    private String created_at;
    private String started_at;
    private String completed_at;

    public ReplicateAIResponse() {
    }

    public ReplicateAIResponse(List<String> output, String id, String status, String created_at, String started_at, String completed_at) {
        this.output = output;
        this.id = id;
        this.status = status;
        this.created_at = created_at;
        this.started_at = started_at;
        this.completed_at = completed_at;
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

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getStarted_at() {
        return started_at;
    }

    public void setStarted_at(String started_at) {
        this.started_at = started_at;
    }

    public String getCompleted_at() {
        return completed_at;
    }

    public void setCompleted_at(String completed_at) {
        this.completed_at = completed_at;
    }
}
