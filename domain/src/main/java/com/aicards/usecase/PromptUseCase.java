package com.aicards.usecase;

import com.aicards.entity.vo.QuestionsResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromptUseCase {

    public String createPrompt(List<QuestionsResponse> vo){
        String prompt = "Crie a Biografia de um personagem com as seguintes predefinições: ";

        for (int i = 0; i < vo.size(); i++){
            prompt += "Pergunta: " + vo.get(i).getQuestionText() + " resposta: " + vo.get(i).getAnswer() + ". ";
        }
        return prompt;
    }
}
