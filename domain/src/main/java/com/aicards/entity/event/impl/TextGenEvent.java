package com.aicards.entity.event.impl;


import com.aicards.entity.event.EventVO;

public class TextGenEvent implements EventVO {


    public TextGenEvent(){

    }

    public TextGenEvent(String prompt, String cardHash) {
        this.prompt = prompt;
        this.cardHash = cardHash;
    }

    private String prompt;
    private String cardHash;

    @Override
    public String toString() {
        return "TextGenEvent{" +
                "prompt='" + prompt + '\'' +
                ", cardHash='" + cardHash + '\'' +
                '}';
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
