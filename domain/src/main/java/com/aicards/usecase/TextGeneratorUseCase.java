package com.aicards.usecase;

import com.aicards.dataprovider.OpenAPIClientProvider;
import com.aicards.entity.CardEntity;
import com.aicards.entity.vo.TextGenEvent;
import org.springframework.stereotype.Service;

@Service
public class TextGeneratorUseCase {

    private final UpdateCardUseCase updateCardUseCase;
    private final OpenAPIClientProvider openAIClient;

    public TextGeneratorUseCase(UpdateCardUseCase updateCardProvider, OpenAPIClientProvider openAIClient) {
        this.updateCardUseCase = updateCardProvider;
        this.openAIClient = openAIClient;
    }

    public CardEntity generateAndUpdateCard(TextGenEvent vo) throws Exception {
        String description = openAIClient.callOpenAI(vo.getPrompt());
        System.out.println(description);
        return updateCardUseCase.updateCardWithText(vo.getCardHash(), description, description);
    }
}
