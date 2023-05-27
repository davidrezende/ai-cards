package com.aicards.usecase;

import com.aicards.dataprovider.CardDataProvider;
import com.aicards.dataprovider.OpenAPIClientProvider;
import com.aicards.entity.CardEntity;
import com.aicards.entity.UserEntity;
import com.aicards.entity.vo.AttributesEnum;
import com.aicards.entity.vo.CreateCardRequest;
import com.aicards.entity.vo.QuestionsResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CardUseCase {

    private final CardDataProvider cardDataProvider;
    private final EventProvider eventProvider;
    private final SaveUserUseCase userUseCase;
    private final QuestionUseCase questionUseCase;
    private final UserUseCase userUseCase;

    public CardUseCase(CardDataProvider cardDataProvider, QuestionUseCase questionUseCase, UserUseCase userUseCase) {
        this.cardDataProvider = cardDataProvider;
        this.eventProvider = eventProvider;
        this.questionUseCase = questionUseCase;
        this.userUseCase = userUseCase;
    }

    public List<CardEntity> findAllCardsByUserId(String userId) {
        return cardDataProvider.findAllCardsByUserId(userId);
    }

    public CardEntity generateCard(CreateCardRequest cardRequest) throws Exception {

        UserEntity userEntity = userUseCase.findUserByUserId(cardRequest.getUserId());
        List<QuestionsResponse> questionsPrompt = cardRequest.getQuestions().stream().map(it ->
                new QuestionsResponse(
                        questionUseCase.findQuestionByQuestionId(it.getQuestionId()).getQuestion(),
                        it.getAnswer()
                )).toList();
        String descriptionGPT = openAIClient.callOpenAI(questionsPrompt);
        Map<AttributesEnum, Integer> attributes = randomizeAttributes();

        CardEntity carta = new CardEntity(
                null,
                null,
                UUID.randomUUID().toString(),
                null,
                attributes,
                questionsPrompt,
                userEntity.getUserId());

        CardEntity card = cardDataProvider.saveCard(carta);

        EventVO textEvent = new TextGenEvent(cardRequest.getPrompt(), card.getCardHash());

        if(card != null){
            eventProvider.sendMessage(textEvent);
            System.out.println("Evento enviado!");
            return card;
        }

        throw new Exception("Erro ao criar carta");
    }

    private Map<AttributesEnum, Integer> randomizeAttributes() {
        Map<AttributesEnum, Integer> attributes = new HashMap<>();
        Random random = new Random();
        for (AttributesEnum attribute : AttributesEnum.values()) {
            attributes.put(attribute, random.nextInt(0, 100));
        }
        return attributes;
    }
}
