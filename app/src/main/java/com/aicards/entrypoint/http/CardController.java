package com.aicards.entrypoint.http;

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

    @GetMapping("/{userId}")
    public List<CardEntity> findUserById(@PathVariable String userId){
        return cardUseCase.findAllCardsByUserId(userId);
    }

    @PostMapping
    @Transactional
    public CardEntity add(@RequestBody CreateCardRequest cardRequest) throws Exception {
        return cardUseCase.saveCard(cardRequest);
    }

}
