package com.aicards.usecase;

import com.aicards.dataprovider.ReplicateClientProvider;
import com.aicards.entity.CardEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ImageGeneratorCardUseCase {

    private final UpdateCardUseCase updateCardUseCase;
    private final ReplicateClientProvider replicateClient;

    public ImageGeneratorCardUseCase(UpdateCardUseCase updateCardUseCase, ReplicateClientProvider replicateClientProvider) {
        this.updateCardUseCase = updateCardUseCase;
        this.replicateClient = replicateClientProvider;
    }

    public ResponseEntity<CardEntity> generateImageAndUpdateCard(String cardHash, String prompt) throws Exception {
        String replicateId = replicateClient.callReplicateAI(prompt);
        System.out.println(replicateId);
        return updateCardUseCase.updateCardWithImage(cardHash, prompt, replicateId);
    }
}
