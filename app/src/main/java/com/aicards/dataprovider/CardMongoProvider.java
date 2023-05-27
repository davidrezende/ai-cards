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

    @Override
    public CardEntity updateCard(CardEntity cardEntity) throws Exception {
        Card cardUpdated = repository.save(new Card().toCard(cardEntity));
        if(cardUpdated == null) throw new Exception("Erro ao atualizar a carta: "+ cardEntity.getCardHash());
        return cardUpdated.toEntity();
    }

    @Override
    public CardEntity findByCardHash(String cardHash) throws Exception {
        Card card = repository.findByCardHash(cardHash);
        if(card == null) throw new Exception("Carta: "+ cardHash +" não encontrada.");
        return card.toEntity();
    }


}
