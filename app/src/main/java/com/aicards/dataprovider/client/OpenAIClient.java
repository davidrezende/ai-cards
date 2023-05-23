package com.aicards.dataprovider.client;

import com.aicards.dataprovider.OpenAPIClientProvider;
import com.aicards.entity.vo.OpenAPIClientResponse;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OpenAIClient implements OpenAPIClientProvider {
    private static final String API_URL = "https://api.openai.com/v1/completions";

    @Override
    public String callOpenAI(String prompt) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth("");

        String requestBody = "{\"model\": \"text-davinci-003\"," +
                "  \"prompt\": \""+prompt+"\"," +
                "  \"temperature\": 0," +
                "  \"max_tokens\": 1024," +
                "  \"top_p\": 1," +
                "  \"frequency_penalty\": 0," +
                "  \"presence_penalty\": 0" +
                "  }";

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
