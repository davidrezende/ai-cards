package com.aicards.dataprovider.client;

import com.aicards.dataprovider.OpenAIClientProvider;
import com.aicards.entity.vo.MessageVO;
import com.aicards.entity.vo.OpenAIClientResponse;
import com.aicards.entity.vo.PromptRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Component
public class OpenAIClient implements OpenAIClientProvider {

    @Value("${config.openai.token}")
    private String token;
    private static final String API_URL = "https://api.openai.com/v1/chat/completions";

    @Override
    public String callOpenAI(List<MessageVO> prompt) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);

        PromptRequest promptRequest = new PromptRequest(
                "gpt-3.5-turbo",
                prompt,
                1,
                200,
                null,
                1,
                0
        );
        String requestBody = new ObjectMapper().writeValueAsString(promptRequest);

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<OpenAIClientResponse> response = restTemplate.exchange(API_URL, HttpMethod.POST, requestEntity, OpenAIClientResponse.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody().getChoices().get(0).getMessage().getContent();
        } else {
            System.out.println("Falha na requisição. Código de status: " + response.getStatusCodeValue());
        }
        return null;
    }
}
