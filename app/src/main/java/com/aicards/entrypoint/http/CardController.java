package com.aicards.entrypoint.http;

import com.aicards.dataprovider.model.Card;
import com.aicards.dataprovider.repository.CardRepository;
import com.aicards.entity.CardEntity;
import com.aicards.entity.vo.CreateCardRequest;
import com.aicards.entity.vo.ReplicateAIResponse;
import com.aicards.usecase.ImageGeneratorCardUseCase;
import com.aicards.usecase.SaveCardUseCase;
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

    @PatchMapping("/{cardHash}/image/prompt")
    public ResponseEntity<CardEntity> generateAndUpdateCardImage(@PathVariable String cardHash, @RequestBody String prompt) throws Exception {
        return imageGeneratorCardUseCase.generateImageAndUpdateCard(cardHash, prompt);
    }

    @PostMapping("/replicate/image")
    public ResponseEntity<CardEntity> webhook(@RequestBody ReplicateAIResponse replicateAIResponse, @RequestParam("cardHash") String cardHash) throws Exception {
        return imageGeneratorCardUseCase.convertAndUpdateCardImage(replicateAIResponse,cardHash);
    }
}
