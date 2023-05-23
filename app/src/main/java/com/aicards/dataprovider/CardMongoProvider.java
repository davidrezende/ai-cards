package com.aicards.dataprovider;

import com.aicards.dataprovider.model.Card;
import com.aicards.dataprovider.repository.CardRepository;
import com.aicards.entity.CardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CardMongoProvider implements CardDataProvider{

    @Autowired
    private CardRepository repository;

    @Override
    public List<CardEntity> findAllCardsByUserId(String userId) {
        return repository.findAllByUserId(userId).stream().map(Card::toEntity).toList();
    }

    @Override
    public CardEntity saveCard(CardEntity cardEntity) {
        return repository.save(new Card().toCard(cardEntity)).toEntity();
    }
}
