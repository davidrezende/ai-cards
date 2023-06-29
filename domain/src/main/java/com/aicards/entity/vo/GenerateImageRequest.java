package com.aicards.entity.vo;

public class GenerateImageRequest {
    private String cardHash;
    private String prompt;

    public GenerateImageRequest(String cardHash, String prompt) {
        this.cardHash = cardHash;
        this.prompt = prompt;
    }

    public String getCardHash() {
        return cardHash;
    }

    public void setCardHash(String cardHash) {
        this.cardHash = cardHash;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
}
