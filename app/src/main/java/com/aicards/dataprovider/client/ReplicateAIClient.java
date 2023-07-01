package com.aicards.dataprovider.client;

import com.aicards.dataprovider.ReplicateClientProvider;
import com.aicards.entity.vo.InputReplicateAIVO;
import com.aicards.entity.vo.ReplicateAIRequest;
import com.aicards.entity.vo.ReplicateAIResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ReplicateAIClient implements ReplicateClientProvider {

    @Value("${config.replicateai.token}")
    private String token;

    @Value("${config.replicateai.api_url}")
    private String API_URL;

    @Value("${config.replicateai.webhook}")
    private String webhook;

    @Override
    public String callReplicateAI(String prompt, String cardHash) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Token "+token);

        ReplicateAIRequest request = new ReplicateAIRequest();
        request.setVersion("db21e45d3f7023abc2a46ee38a23973f6dce16bb082a930b0c49861f96d1e5bf");
        request.setInput(new InputReplicateAIVO(prompt));
        request.setWebhook(webhook + "/v1/card/replicate/image?cardHash=" + cardHash);

        String requestBody = new ObjectMapper().writeValueAsString(request);
        System.out.println(requestBody);
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<ReplicateAIResponse> response = restTemplate.exchange(API_URL, HttpMethod.POST, requestEntity, ReplicateAIResponse.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            System.out.println(response.getBody().getOutput());
            return response.getBody().getId();
        } else {
            System.out.println("Falha na requisição. Código de status: " + response.getStatusCodeValue());
        }
        return null;
    }
}
