package com.aicards.dataprovider.model;


import com.aicards.entity.CardEntity;
import com.aicards.entity.vo.AttributesEnum;
import org.springframework.data.annotation.Id;
import java.util.Map;

public class Card {

    @Id
    private String id;
    private String cardHash;
    private String name;
    private String description;
    private Map<AttributesEnum, Integer> attributes;
    private String userId;

    public Card(String id, String name, String cardHash, String description, Map<AttributesEnum, Integer> attributes, String userId){
        this.id = id;
        this.name = name;
        this.cardHash = cardHash;
        this.description = description;
        this.attributes = attributes;
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

    public Card toCard(CardEntity cardEntity){
        return new Card(
                cardEntity.getId(),
                cardEntity.getCardHash(),
                cardEntity.getName(),
                cardEntity.getDescription(),
                cardEntity.getAttributes(),
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
                this.userId
        );
    }
}
