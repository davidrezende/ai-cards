package com.aicards.entity.vo;

public class ReplicateAIRequest {

    private String version;
    private InputReplicateAIVO input;
    private String webhook;

    public ReplicateAIRequest(String version, InputReplicateAIVO input, String webhook) {
        this.version = version;
        this.input = input;
        this.webhook = webhook;
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

    public String getWebhook() {
        return webhook;
    }

    public void setWebhook(String webhook) {
        this.webhook = webhook;
    }
}
