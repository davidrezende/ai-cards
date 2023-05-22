package com.aicards.entrypoint.http;

import com.aicards.dataprovider.model.AttributesEnum;
import com.aicards.dataprovider.model.Card;
import com.aicards.dataprovider.model.User;
import com.aicards.dataprovider.repository.CardRepository;
import com.aicards.dataprovider.repository.UserRepository;
import com.aicards.entity.vo.CreateCardRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/v1/card")
public class CardController {

    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{userId}")
    public List<Card> findUserById(@PathVariable String userId){
        return cardRepository.findAllByUserId(userId);
    }

    @PostMapping
    @Transactional
    public Card add(@RequestBody CreateCardRequest cardRequest) throws Exception {
        try{
            User user = userRepository.findByUserId(cardRequest.getUserId());
            if(user != null){
                Map<AttributesEnum, Integer> attributes = new HashMap<>();
                Random random = new Random();
                for (AttributesEnum attribute : AttributesEnum.values()){
                    attributes.put(attribute, random.nextInt(0,100));
                }
                Card carta = new Card("Carta", UUID.randomUUID().toString(), "É uma carta", attributes, user.getUserId());
                return cardRepository.save(carta);
            }
            throw new Exception("Usuário não existe!");
        }catch (Exception e){
            throw new Exception("Erro inesperado!" + e.getMessage());
        }
    }

}
