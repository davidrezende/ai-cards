package com.aicards.usecase;

import com.aicards.entity.vo.MessageVO;
import com.aicards.entity.vo.QuestionsResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PromptUseCase {

    public List<MessageVO> createPrompt(List<QuestionsResponse> vo) {
        List<MessageVO> messages = new ArrayList<>();

        messages.add(new MessageVO("system", "O usuário irá mandar uma sequência de perguntas e respostas feitas em uma entrevista, você deve criar a biografia de um personagem utilizando os dados. Finalize a biografia em menos de 110 palavras."));
        StringBuilder prompt = new StringBuilder();
        for (QuestionsResponse questionsResponse : vo) {
            prompt
                    .append("Pergunta: ").append(questionsResponse.getQuestionText()).append(" ")
                    .append("Resposta: ").append(questionsResponse.getAnswer()).append(". ");
        }

        messages.add(new MessageVO("user", prompt.toString()));

        return messages;
    }

    public String createImagePrompt(String userPrompt){
        StringBuilder prompt = new StringBuilder(userPrompt);

        prompt
                .append(", clear facial features, fantasy concept art, intricate details, cinematic, majestic background, art by wlop, digital painting, smooth lighting, looking towards the viewer, global illumination –uplight –v 4, ultra-detailed, depth of field, Shutter Speed 1/1000, photoshoot, OpenGL-Shader’s, RTX, Anti-aliasing");

        return prompt.toString();
    }
}
