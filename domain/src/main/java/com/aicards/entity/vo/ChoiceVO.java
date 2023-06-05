package com.aicards.entity.vo;

public class ChoiceVO {
    private MessageVO message;

    public ChoiceVO(MessageVO message) {
        this.message = message;
    }

    public ChoiceVO(){

    }

    public MessageVO getMessage() {
        return message;
    }

    public void setMessage(MessageVO message) {
        this.message = message;
    }
}
