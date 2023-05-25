package com.aicards.dataprovider;

import com.aicards.entity.vo.QuestionsResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface OpenAPIClientProvider {
    String callOpenAI(List<QuestionsResponse> prompt) throws JsonProcessingException;
}
