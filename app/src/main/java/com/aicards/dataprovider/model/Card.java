package com.aicards.dataprovider.model;


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

    public Card(String name, String cardHash, String description, Map<AttributesEnum, Integer> attributes, String userId){
        this.name = name;
        this.cardHash = cardHash;
        this.description = description;
        this.attributes = attributes;
        this.userId = userId;
    }
}
