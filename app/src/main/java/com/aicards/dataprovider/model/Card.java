package com.aicards.dataprovider.model;


import com.aicards.entity.CardEntity;
import com.aicards.entity.vo.AttributesEnum;
import com.aicards.entity.vo.QuestionsResponse;
import com.aicards.entity.vo.StatusEnum;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
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
    private StatusEnum status;
    private LocalDateTime datCreation;
    private LocalDateTime datUpdate;

    public Card(String id, String cardHash, String name, String description, Map<AttributesEnum, Integer> attributes, List<QuestionsResponse> prompt, String userId, StatusEnum status, LocalDateTime datCreation, LocalDateTime datUpdate) {
        this.id = id;
        this.cardHash = cardHash;
        this.name = name;
        this.description = description;
        this.attributes = attributes;
        this.prompt = prompt;
        this.userId = userId;
        this.status = status;
        this.datCreation = datCreation;
        this.datUpdate = datUpdate;
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

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public LocalDateTime getDatCreation() {
        return datCreation;
    }

    public void setDatCreation(LocalDateTime datCreation) {
        this.datCreation = datCreation;
    }

    public LocalDateTime getDatUpdate() {
        return datUpdate;
    }

    public void setDatUpdate(LocalDateTime datUpdate) {
        this.datUpdate = datUpdate;
    }

    public Card toCard(CardEntity cardEntity){
        return new Card(
                cardEntity.getId(),
                cardEntity.getCardHash(),
                cardEntity.getName(),
                cardEntity.getDescription(),
                cardEntity.getAttributes(),
                cardEntity.getPrompt(),
                cardEntity.getUserId(),
                cardEntity.getStatus(),
                cardEntity.getDatCreation(),
                cardEntity.getDatUpdate()
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
                this.userId,
                this.status,
                this.datCreation,
                this.datUpdate
        );
    }
}
