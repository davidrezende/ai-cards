package com.aicards.dataprovider;

import com.aicards.entity.vo.MessageVO;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface OpenAIClientProvider {
    String callOpenAI(List<MessageVO> prompt) throws JsonProcessingException;
}
