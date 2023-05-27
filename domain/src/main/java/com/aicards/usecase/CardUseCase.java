package com.aicards.usecase;

import com.aicards.dataprovider.CardDataProvider;
import com.aicards.dataprovider.EventProvider;
import com.aicards.entity.CardEntity;
import com.aicards.entity.UserEntity;
import com.aicards.entity.vo.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CardUseCase {

    private final CardDataProvider cardDataProvider;
    private final EventProvider eventProvider;
    private final SaveUserUseCase userUseCase;
    private final QuestionUseCase questionUseCase;

    public CardUseCase(CardDataProvider cardDataProvider, EventProvider eventProvider, SaveUserUseCase userUseCase, QuestionUseCase questionUseCase) {
        this.cardDataProvider = cardDataProvider;
        this.eventProvider = eventProvider;
        this.userUseCase = userUseCase;
        this.questionUseCase = questionUseCase;
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

//        TODO: criar usecase para criar o prompt colocar o código abaixo

        String prompt = "Crie a Biografia de um personagem com as seguintes predefinições: ";

        for (int i = 0; i < questionsPrompt.size(); i++){
            prompt += "Pergunta: " + questionsPrompt.get(i).getQuestionText() + " resposta: " + questionsPrompt.get(i).getAnswer() + ". ";
        }

        EventVO textEvent = new TextGenEvent(prompt, card.getCardHash());

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
