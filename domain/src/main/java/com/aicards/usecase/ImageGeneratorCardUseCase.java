package com.aicards.usecase;

import com.aicards.dataprovider.ReplicateClientProvider;
import com.aicards.entity.CardEntity;
import com.aicards.entity.vo.GenerateImageRequest;
import com.aicards.entity.vo.ReplicateAIResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.util.Base64;

@Service
public class ImageGeneratorCardUseCase {

    private final UpdateCardUseCase updateCardUseCase;
    private final PromptUseCase promptUseCase;
    private final ReplicateClientProvider replicateClient;

    public ImageGeneratorCardUseCase(UpdateCardUseCase updateCardUseCase, PromptUseCase promptUseCase, ReplicateClientProvider replicateClientProvider) {
        this.updateCardUseCase = updateCardUseCase;
        this.promptUseCase = promptUseCase;
        this.replicateClient = replicateClientProvider;
    }

    public ResponseEntity<CardEntity> generateImageAndUpdateCard(GenerateImageRequest request) throws Exception {
        String prompt = promptUseCase.createImagePrompt(request.getPrompt());
        String replicateId = replicateClient.callReplicateAI(prompt, request.getCardHash());
        System.out.println("Replicate ID: " + replicateId);
        return updateCardUseCase.updateCardWithReplicateId(request.getCardHash(), prompt, replicateId);
    }

    public ResponseEntity<CardEntity> convertAndUpdateCardImage(ReplicateAIResponse replicateResponse, String cardHash) throws Exception {
        URL url = new URL(replicateResponse.getOutput().get(0));
        BufferedImage image = ImageIO.read(url);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", bos );
        byte [] data = bos.toByteArray();
        image.flush();
        bos.close();
        String imageBase64 = Base64.getEncoder().encodeToString(data);

        return updateCardUseCase.updateCardWithImage(cardHash, imageBase64, replicateResponse);
    }
}
