package com.aicards.usecase;

import com.aicards.dataprovider.CardDataProvider;
import com.aicards.entity.CardEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UpdateCardUseCase {

    private final CardDataProvider cardDataProvider;

    public UpdateCardUseCase(CardDataProvider cardDataProvider, UserUseCase userUseCase) {
        this.cardDataProvider = cardDataProvider;
    }

    public CardEntity updateCardWithText(String cardHash, String name, String description) throws Exception {
        CardEntity card = cardDataProvider.findByCardHash(cardHash);
        card.setName("Nome da carta");
        card.setDescription(description);
        card.setStatus(true);
        card.setDatUpdate(LocalDateTime.now());
        return cardDataProvider.updateCard(card);
    }


}
