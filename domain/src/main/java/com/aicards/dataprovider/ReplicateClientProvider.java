package com.aicards.dataprovider;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;

public interface ReplicateClientProvider {
    String callReplicateAI(String prompt) throws JsonProcessingException;
    ResponseEntity<String> getPrediction(String id);
}
