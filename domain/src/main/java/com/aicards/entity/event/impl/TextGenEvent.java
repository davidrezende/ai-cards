package com.aicards.entity.event.impl;


import com.aicards.entity.event.EventVO;
import com.aicards.entity.vo.MessageVO;

import java.util.List;

public class TextGenEvent implements EventVO {


    public TextGenEvent(){

    }

    public TextGenEvent(List<MessageVO> prompt, String cardHash) {
        this.prompt = prompt;
        this.cardHash = cardHash;
    }

    private List<MessageVO> prompt;
    private String cardHash;

    @Override
    public String toString() {
        return "TextGenEvent{" +
                "prompt='" + prompt + '\'' +
                ", cardHash='" + cardHash + '\'' +
                '}';
    }

    public List<MessageVO> getPrompt() {
        return prompt;
    }

    public void setPrompt(List<MessageVO> prompt) {
        this.prompt = prompt;
    }

    public String getCardHash() {
        return cardHash;
    }

    public void setCardHash(String cardHash) {
        this.cardHash = cardHash;
    }
}
