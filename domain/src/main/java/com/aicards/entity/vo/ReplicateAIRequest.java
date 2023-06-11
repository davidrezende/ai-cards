package com.aicards.entity.vo;

public class ReplicateAIRequest {

    private String version;
    private InputReplicateAIVO input;

    public ReplicateAIRequest(String version, InputReplicateAIVO input) {
        this.version = version;
        this.input = input;
    }

    public ReplicateAIRequest() {
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public InputReplicateAIVO getInput() {
        return input;
    }

    public void setInput(InputReplicateAIVO input) {
        this.input = input;
    }
}
