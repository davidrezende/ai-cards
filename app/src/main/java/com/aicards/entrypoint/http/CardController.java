package com.aicards.entrypoint.http;

import com.aicards.dataprovider.model.Card;
import com.aicards.dataprovider.repository.CardRepository;
import com.aicards.entity.CardEntity;
import com.aicards.entity.vo.CreateCardRequest;
import com.aicards.entity.vo.GenerateImageRequest;
import com.aicards.entity.vo.ReplicateAIResponse;
import com.aicards.entity.vo.UpdateNameRequest;
import com.aicards.usecase.ImageGeneratorCardUseCase;
import com.aicards.usecase.SaveCardUseCase;
import com.aicards.usecase.UpdateCardUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/card")
public class CardController {

    @Autowired
    private SaveCardUseCase cardUseCase;

    @Autowired
    private ImageGeneratorCardUseCase imageGeneratorCardUseCase;

    @Autowired
    private CardRepository repository;

    @Autowired
    private UpdateCardUseCase updateCardUseCase;

    @GetMapping("/user/{userId}")
    public List<CardEntity> findAllCardsByUserId(@PathVariable String userId) {
        return cardUseCase.findAllCardsByUserId(userId);
    }

    @PostMapping
    @Transactional
    public CardEntity add(@RequestBody CreateCardRequest cardRequest) throws Exception {
        return cardUseCase.generateCard(cardRequest);
    }

    @GetMapping("/{cardHash}")
    public Card getByCardHash(@PathVariable String cardHash) {
        return repository.findByCardHash(cardHash);
    }

    @PatchMapping("/image/prompt")
    public ResponseEntity<CardEntity> generateAndUpdateCardImage(@RequestBody GenerateImageRequest request) throws Exception {
        return imageGeneratorCardUseCase.generateImageAndUpdateCard(request);
    }

    @PostMapping("/replicate/image")
    public ResponseEntity<CardEntity> webhook(@RequestBody ReplicateAIResponse replicateAIResponse, @RequestParam("cardHash") String cardHash) throws Exception {
        return imageGeneratorCardUseCase.convertAndUpdateCardImage(replicateAIResponse,cardHash);
    }

    @PatchMapping("/name")
    public ResponseEntity<String> updateCardName(@RequestBody UpdateNameRequest updateNameRequest) throws Exception {
        return updateCardUseCase.updateCardName(updateNameRequest);
    }
}
