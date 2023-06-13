package com.aicards.dataprovider;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface OpenAIClientProvider {
    String callOpenAI(String prompt) throws JsonProcessingException;
}
