package com.aicards.usecase;

import com.aicards.dataprovider.ReplicateClientProvider;
import com.aicards.entity.CardEntity;
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
    private final ReplicateClientProvider replicateClient;

    public ImageGeneratorCardUseCase(UpdateCardUseCase updateCardUseCase, ReplicateClientProvider replicateClientProvider) {
        this.updateCardUseCase = updateCardUseCase;
        this.replicateClient = replicateClientProvider;
    }

    public ResponseEntity<CardEntity> generateImageAndUpdateCard(String cardHash, String prompt) throws Exception {
        String replicateId = replicateClient.callReplicateAI(prompt, cardHash);
        System.out.println(replicateId);
        return updateCardUseCase.updateCardWithReplicateId(cardHash, prompt, replicateId);
    }

    public ResponseEntity<CardEntity> convertAndUpdateCardImage(String imageUrl, String cardHash) throws Exception {
        URL url = new URL(imageUrl);
        BufferedImage image = ImageIO.read(url);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", bos );
        byte [] data = bos.toByteArray();
        image.flush();
        bos.close();
        String imageBase64 = Base64.getEncoder().encodeToString(data);

        return updateCardUseCase.updateCardWithImage(cardHash, imageBase64);
    }
}
