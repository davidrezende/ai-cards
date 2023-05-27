package com.aicards.entrypoint.http;

import com.aicards.dataprovider.model.Card;
import com.aicards.dataprovider.repository.CardRepository;
import com.aicards.entity.CardEntity;
import com.aicards.entity.vo.CreateCardRequest;
import com.aicards.usecase.CardUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/v1/card")
public class CardController {

    @Autowired
    private CardUseCase cardUseCase;

    @Autowired
    private CardRepository repository;

    @GetMapping("/user/{userId}")
    public List<CardEntity> findAllCardsByUserId(@PathVariable String userId){
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

}
