package com.aicards.usecase;

import com.aicards.dataprovider.CardDataProvider;
import com.aicards.dataprovider.OpenAPIClientProvider;
import com.aicards.entity.CardEntity;
import com.aicards.entity.UserEntity;
import com.aicards.entity.vo.AttributesEnum;
import com.aicards.entity.vo.CreateCardRequest;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CardUseCase {

    private final CardDataProvider cardDataProvider;
    
    private final OpenAPIClientProvider openAIClient;
    private final UserUseCase userUseCase;

    public CardUseCase(CardDataProvider cardDataProvider, OpenAPIClientProvider openAIClient, UserUseCase userUseCase) {
        this.cardDataProvider = cardDataProvider;
        this.openAIClient = openAIClient;
        this.userUseCase = userUseCase;
    }

    public List<CardEntity> findAllCardsByUserId(String userId) {
        return cardDataProvider.findAllCardsByUserId(userId);
    }

    public CardEntity saveCard(CreateCardRequest cardRequest) throws Exception {
        try {
            UserEntity userEntity = userUseCase.findUserByUserId(cardRequest.getUserId());
            if (userEntity != null) {
                String descriptionGPT = openAIClient.callOpenAI(cardRequest.getPrompt());
                Map<AttributesEnum, Integer> attributes = new HashMap<>();
                Random random = new Random();
                for (AttributesEnum attribute : AttributesEnum.values()) {
                    attributes.put(attribute, random.nextInt(0, 100));
                }
                CardEntity carta = new CardEntity(
                        null,
                        "Carta",
                        UUID.randomUUID().toString(),
                        descriptionGPT,
                        attributes,
                        userEntity.getUserId());
                return cardDataProvider.saveCard(carta);
            }
            throw new Exception("Usuário não existe!");
        } catch (Exception e) {
            throw new Exception("Erro inesperado!" + e.getMessage());
        }
    }
}
