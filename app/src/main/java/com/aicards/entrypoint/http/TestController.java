package com.aicards.entrypoint.http;

import com.aicards.dataprovider.client.ReplicateAIClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/test")
public class TestController {

    @Autowired
    private ReplicateAIClient clientAIImage;


    @GetMapping("/image/{prompt}")
    public String testImage(@PathVariable String prompt) throws JsonProcessingException {
        return clientAIImage.callReplicateAI(prompt);
    }
}
