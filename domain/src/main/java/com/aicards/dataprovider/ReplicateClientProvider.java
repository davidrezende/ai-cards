package com.aicards.dataprovider;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface ReplicateClientProvider {
    String callReplicateAI(String prompt) throws JsonProcessingException;
}
