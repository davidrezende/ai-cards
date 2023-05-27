package com.aicards.dataprovider.model;


import com.aicards.entity.CardEntity;
import com.aicards.entity.vo.AttributesEnum;
import com.aicards.entity.vo.QuestionsResponse;
import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.Map;

public class Card {

    @Id
    private String id;
    private String cardHash;
    private String name;
    private String description;
    private Map<AttributesEnum, Integer> attributes;
    private List<QuestionsResponse> prompt;
    private String userId;

    public Card(String id, String cardHash, String name, String description, Map<AttributesEnum, Integer> attributes, List<QuestionsResponse> prompt, String userId){
        this.id = id;
        this.name = name;
        this.cardHash = cardHash;
        this.description = description;
        this.attributes = attributes;
        this.prompt = prompt;
        this.userId = userId;
    }

    public Card(){}

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

    public Card toCard(CardEntity cardEntity){
        return new Card(
                cardEntity.getId(),
                cardEntity.getCardHash(),
                cardEntity.getName(),
                cardEntity.getDescription(),
                cardEntity.getAttributes(),
                cardEntity.getPrompt(),
                cardEntity.getUserId()
        );
    }

    public CardEntity toEntity(){
        return new CardEntity(
                this.id,
                this.cardHash,
                this.name,
                this.description,
                this.attributes,
                this.prompt,
                this.userId
        );
    }
}
