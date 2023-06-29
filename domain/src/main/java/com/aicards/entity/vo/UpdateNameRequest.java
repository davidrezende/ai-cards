package com.aicards.entity.vo;

public class UpdateNameRequest {
    private String cardHash;
    private String name;

    public UpdateNameRequest(String cardhash, String cardName) {
        this.cardHash = cardhash;
        this.name = cardName;
    }

    public String getCardHash() {
        return cardHash;
    }

    public void setCardHash(String cardHash) {
        this.cardHash = cardHash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
