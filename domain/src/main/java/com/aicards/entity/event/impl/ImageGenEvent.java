package com.aicards.entity.event.impl;

import com.aicards.entity.event.EventVO;

public class ImageGenEvent implements EventVO {

    private String prompt;
    private String cardHash;

    @Override
    public String toString() {
        return "ImageGenEvent{" +
                "prompt='" + prompt + '\'' +
                ", cardHash='" + cardHash + '\'' +
                '}';
    }

    public ImageGenEvent(String prompt, String cardHash) {
        this.prompt = prompt;
        this.cardHash = cardHash;
    }

    public ImageGenEvent() {
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getCardHash() {
        return cardHash;
    }

    public void setCardHash(String cardHash) {
        this.cardHash = cardHash;
    }
}
