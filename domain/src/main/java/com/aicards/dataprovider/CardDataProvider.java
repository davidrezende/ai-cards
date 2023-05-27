package com.aicards.dataprovider;

import com.aicards.entity.CardEntity;

import java.util.List;

public interface CardDataProvider {
    List<CardEntity> findAllCardsByUserId(String userId);
    CardEntity saveCard(CardEntity cardEntity);

    CardEntity updateCard(CardEntity cardEntity) throws Exception;

    CardEntity findByCardHash(String cardHash) throws Exception;
}
