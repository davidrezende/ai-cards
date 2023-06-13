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
    private static final String API_URL = "https://api.replicate.com/v1/predictions";

    @Override
    public String callReplicateAI(String prompt) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Token "+token);

        ReplicateAIRequest request = new ReplicateAIRequest();
        request.setVersion("e5e1fd333a08c8035974a01dd42f799f1cca4625aec374643d716d9ae40cf2e4");
        request.setInput(new InputReplicateAIVO(prompt + ", clear facial features, fantasy concept art, intricate details, cinematic, majestic background, art by wlop, digital painting, smooth lighting, looking towards the viewer, global illumination –uplight –v 4, ultra-detailed, depth of field, Shutter Speed 1/1000, photoshoot, OpenGL-Shader’s, RTX, Anti-aliasing"));

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
