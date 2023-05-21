package com.aicards.entrypoint.http;

import com.aicards.dataprovider.model.AttributesEnum;
import com.aicards.dataprovider.model.Card;
import com.aicards.dataprovider.model.User;
import com.aicards.dataprovider.repository.CardRepository;
import com.aicards.dataprovider.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/v1/card")
public class CardController {

    @Autowired
    private CardRepository repository;

    @GetMapping("/{userId}")
    public List<Card> findUserById(@PathVariable String userId){
        return repository.findAllByUserId(userId);
    }

    @PostMapping
    public Card add(){
        Map<AttributesEnum, Integer> attributes = new HashMap<>();
        Random random = new Random();
        for (AttributesEnum attribute : AttributesEnum.values()){
            attributes.put(attribute, random.nextInt(0,100));
        }
        Card carta = new Card("Carta", UUID.randomUUID().toString(), "É uma carta", attributes, UUID.randomUUID().toString());
        return repository.save(carta);
    }

}
