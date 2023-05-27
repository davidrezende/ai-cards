package com.aicards.usecase;

import com.aicards.dataprovider.CardDataProvider;
import com.aicards.entity.CardEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdateCardUseCase {

    private final CardDataProvider cardDataProvider;
    private final SaveUserUseCase userUseCase;

    public UpdateCardUseCase(CardDataProvider cardDataProvider, SaveUserUseCase userUseCase) {
        this.cardDataProvider = cardDataProvider;
        this.userUseCase = userUseCase;
    }

    public CardEntity updateCardWithText(String cardHash, String name, String description) throws Exception {
        CardEntity card = cardDataProvider.findByCardHash(cardHash);
        card.setName(name);
        card.setDescription(description);
        return cardDataProvider.updateCard(card);
    }


}
