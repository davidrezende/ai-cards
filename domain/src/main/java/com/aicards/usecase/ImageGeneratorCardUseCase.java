package com.aicards.usecase;

import com.aicards.entity.CardEntity;
import com.aicards.entity.event.impl.ImageGenEvent;
import org.springframework.stereotype.Service;

@Service
public class ImageGeneratorCardUseCase {

    private final UpdateCardUseCase updateCardUseCase;

    public ImageGeneratorCardUseCase(UpdateCardUseCase updateCardUseCase) {
        this.updateCardUseCase = updateCardUseCase;
    }

    public CardEntity generateAndUpdateCard(ImageGenEvent vo) throws Exception {
        //chamar api para gerar img
        String image = "*Image*";
        System.out.println(image);
        return updateCardUseCase.updateCardWithImage(vo.getCardHash(), image);
    }
}
