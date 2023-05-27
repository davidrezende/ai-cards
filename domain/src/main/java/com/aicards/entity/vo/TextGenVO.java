package com.aicards.entity.vo;

public class TextGenVO {
    private String cardHash;
    private String prompt;

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

    @Override
    public String toString() {
        return "TextGeneratorVO{" +
                "cardHash='" + cardHash + '\'' +
                ", prompt='" + prompt + '\'' +
                '}';
    }
}
