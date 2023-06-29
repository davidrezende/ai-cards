package com.aicards.usecase;

import com.aicards.dataprovider.CardDataProvider;
import com.aicards.entity.CardEntity;
import com.aicards.entity.vo.ImageVO;
import com.aicards.entity.vo.ReplicateAIResponse;
import com.aicards.entity.vo.StatusEnum;
import com.aicards.entity.vo.UpdateNameRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UpdateCardUseCase {

    private final CardDataProvider cardDataProvider;

    public UpdateCardUseCase(CardDataProvider cardDataProvider, UserUseCase userUseCase) {
        this.cardDataProvider = cardDataProvider;
    }

    public CardEntity updateCardWithText(String cardHash, String name, String description) throws Exception {
        CardEntity card = cardDataProvider.findByCardHash(cardHash);
        card.setName("Nome da carta");
        card.setDescription(description);
        card.setStatus(StatusEnum.TEXT_CREATED);
        card.setDatUpdate(LocalDateTime.now());
        return cardDataProvider.updateCard(card);

    }
    public ResponseEntity<CardEntity> updateCardWithReplicateId(String cardHash, String prompt, String replicateId) throws Exception {
        CardEntity card = cardDataProvider.findByCardHash(cardHash);
        card.setImage(new ImageVO(
                replicateId,
                null,
                null,
                null,
                prompt,
                null
        ));
        card.setStatus(StatusEnum.PROCESSING_IMAGE);
        card.setDatUpdate(LocalDateTime.now());
        return ResponseEntity.ok(cardDataProvider.updateCard(card));
    }

    public ResponseEntity<CardEntity> updateCardWithImage(String cardHash, String imageBase64, ReplicateAIResponse replicateResponse) throws Exception {
        CardEntity card = cardDataProvider.findByCardHash(cardHash);
        card.setImage(new ImageVO(
                card.getImage().getIdReplicate(),
                replicateResponse.getCreated_at(),
                replicateResponse.getStarted_at(),
                replicateResponse.getCompleted_at(),
                card.getImage().getPrompt(),
                imageBase64
                ));
        card.setStatus(StatusEnum.CREATED);
        card.setDatUpdate(LocalDateTime.now());
        return ResponseEntity.ok(cardDataProvider.updateCard(card));
    }

    public ResponseEntity<String> updateCardName(UpdateNameRequest updateNameRequest) throws Exception {
        CardEntity card = cardDataProvider.findByCardHash(updateNameRequest.getCardHash());
        card.setName(updateNameRequest.getName());
        return ResponseEntity.ok(cardDataProvider.updateCard(card).getName());
    }

}
