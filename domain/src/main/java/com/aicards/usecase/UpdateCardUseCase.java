package com.aicards.usecase;

import com.aicards.dataprovider.CardDataProvider;
import com.aicards.entity.CardEntity;
import com.aicards.entity.vo.ImageVO;
import com.aicards.entity.vo.StatusEnum;
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
        if ((card.getStatus().equals(StatusEnum.IMAGE_CREATED))) {
            card.setStatus(StatusEnum.CREATED);
        } else {
            card.setStatus(StatusEnum.TEXT_CREATED);
        }
        card.setDatUpdate(LocalDateTime.now());
        return cardDataProvider.updateCard(card);

    }
    public ResponseEntity<CardEntity> updateCardWithReplicateId(String cardHash, String prompt, String replicateId) throws Exception {
        CardEntity card = cardDataProvider.findByCardHash(cardHash);
        card.setImage(new ImageVO(
                replicateId,
                null,
                prompt
        ));
        card.setStatus(StatusEnum.PROCESSING_IMAGE);
        card.setDatUpdate(LocalDateTime.now());
        return ResponseEntity.ok(cardDataProvider.updateCard(card));
    }

    public ResponseEntity<CardEntity> updateCardWithImage(String cardHash, String image) throws Exception {
        CardEntity card = cardDataProvider.findByCardHash(cardHash);
        card.setImage(new ImageVO(
                card.getImage().getIdReplicate(),
                image,
                card.getImage().getPrompt()
        ));
        card.setStatus(StatusEnum.IMAGE_CREATED);
        card.setDatUpdate(LocalDateTime.now());
        return ResponseEntity.ok(cardDataProvider.updateCard(card));
    }

}
