package com.aicards.dataprovider;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface OpenAPIClientProvider {
    String callOpenAI(String prompt) throws JsonProcessingException;
}
