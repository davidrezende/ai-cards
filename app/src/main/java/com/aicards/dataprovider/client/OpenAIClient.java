package com.aicards.dataprovider.client;

import com.aicards.dataprovider.OpenAPIClientProvider;
import com.aicards.entity.vo.OpenAPIClientResponse;
import com.aicards.entity.vo.PromptRequest;
import com.aicards.entity.vo.QuestionsResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class OpenAIClient implements OpenAPIClientProvider {
    private static final String API_URL = "https://api.openai.com/v1/completions";

    @Override
    public String callOpenAI(List<QuestionsResponse> questions) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth("");
        String prompt = "Crie a Biografia de um personagem com as seguintes predefinições: ";

        for (int i = 0; i < questions.size(); i++){
            prompt += "Pergunta: " + questions.get(i).getQuestionText() + " resposta: " + questions.get(i).getAnswer() + ". ";
        }

        PromptRequest promptRequest = new PromptRequest(
                "text-davinci-003",
                prompt,
                0,
                1024,
                1,
                0,
                0
        );
        String requestBody = new ObjectMapper().writeValueAsString(promptRequest);

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<OpenAPIClientResponse> response = restTemplate.exchange(API_URL, HttpMethod.POST, requestEntity, OpenAPIClientResponse.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody().getChoices().get(0).getText();
        } else {
            System.out.println("Falha na requisição. Código de status: " + response.getStatusCodeValue());
        }
        return null;
    }
}
