package com.aicards.entity;


import com.aicards.entity.vo.AttributesEnum;
import com.aicards.entity.vo.QuestionsResponse;

import java.util.List;
import java.util.Map;

public class CardEntity {

    private String id;
    private String cardHash;
    private String name;
    private String description;
    private Map<AttributesEnum, Integer> attributes;
    private List<QuestionsResponse> prompt;
    private String userId;

    public CardEntity(String id, String name, String cardHash, String description, Map<AttributesEnum, Integer> attributes, List<QuestionsResponse> prompt, String userId){
        this.id = id;
        this.name = name;
        this.cardHash = cardHash;
        this.description = description;
        this.attributes = attributes;
        this.prompt = prompt;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<AttributesEnum, Integer> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<AttributesEnum, Integer> attributes) {
        this.attributes = attributes;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<QuestionsResponse> getPrompt() {
        return prompt;
    }

    public void setPrompt(List<QuestionsResponse> prompt) {
        this.prompt = prompt;
    }
}
