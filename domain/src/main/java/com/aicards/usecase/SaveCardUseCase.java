package com.aicards.usecase;

import com.aicards.dataprovider.CardDataProvider;
import com.aicards.dataprovider.EventProducerProvider;
import com.aicards.entity.CardEntity;
import com.aicards.entity.UserEntity;
import com.aicards.entity.event.EventVO;
import com.aicards.entity.event.impl.TextGenEvent;
import com.aicards.entity.vo.AttributesEnum;
import com.aicards.entity.vo.CreateCardRequest;
import com.aicards.entity.vo.QuestionsResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SaveCardUseCase {

    @Value("${config.rabbit.queues.text-generator}")
    private String textGeneratorQueueName;

    private final CardDataProvider cardDataProvider;
    private final EventProducerProvider eventProducerProvider;
    private final UserUseCase userUseCase;
    private final QuestionUseCase questionUseCase;
    private final PromptUseCase promptUseCase;

    public SaveCardUseCase(CardDataProvider cardDataProvider, EventProducerProvider eventProvider, UserUseCase userUseCase, QuestionUseCase questionUseCase, PromptUseCase promptUseCase) {
        this.cardDataProvider = cardDataProvider;
        this.eventProducerProvider = eventProvider;
        this.userUseCase = userUseCase;
        this.questionUseCase = questionUseCase;
        this.promptUseCase = promptUseCase;
    }


    public List<CardEntity> findAllCardsByUserId(String userId) {
        return cardDataProvider.findAllCardsByUserId(userId);
    }

    public CardEntity generateCard(CreateCardRequest cardRequest) throws Exception {

        UserEntity userEntity = userUseCase.findUserByUserId(cardRequest.getUserId());
        List<QuestionsResponse> questionsPrompt = questionUseCase.createListQuestionsResponse(cardRequest.getQuestions());
        Map<AttributesEnum, Integer> attributes = randomizeAttributes();

        CardEntity carta = new CardEntity(
                null,
                UUID.randomUUID().toString(),
                null,
                null,
                attributes,
                questionsPrompt,
                userEntity.getUserId());

        CardEntity card = cardDataProvider.saveCard(carta);
        String prompt = promptUseCase.createPrompt(questionsPrompt);

        if(card != null){
            EventVO textEvent = new TextGenEvent(prompt, card.getCardHash());
            eventProducerProvider.sendMessage(textGeneratorQueueName, textEvent);
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
