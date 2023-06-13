package com.aicards.usecase;

import com.aicards.dataprovider.OpenAIClientProvider;
import com.aicards.entity.CardEntity;
import com.aicards.entity.event.impl.TextGenEvent;
import org.springframework.stereotype.Service;

@Service
public class TextGeneratorCardUseCase {

    private final UpdateCardUseCase updateCardUseCase;
    private final OpenAIClientProvider openAIClient;

    public TextGeneratorCardUseCase(UpdateCardUseCase updateCardProvider, OpenAIClientProvider openAIClient) {
        this.updateCardUseCase = updateCardProvider;
        this.openAIClient = openAIClient;
    }

    public CardEntity generateAndUpdateCard(TextGenEvent vo) throws Exception {
        String description = openAIClient.callOpenAI(vo.getPrompt());
        System.out.println(description);
        return updateCardUseCase.updateCardWithText(vo.getCardHash(), description, description);
    }
}
