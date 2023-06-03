package com.aicards.usecase;

import com.aicards.entity.vo.QuestionsResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromptUseCase {

    public String createPrompt(List<QuestionsResponse> vo) {
        StringBuilder prompt = new StringBuilder("Crie a Biografia de um personagem com as seguintes predefinições: ");

        for (QuestionsResponse questionsResponse : vo) {
            prompt
                    .append("Pergunta: ").append(questionsResponse.getQuestionText()).append(" ")
                    .append("Resposta: ").append(questionsResponse.getAnswer()).append(". ");
        }
        return prompt.toString();
    }
}
