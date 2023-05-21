package com.aicards.dataprovider.repository;

import com.aicards.dataprovider.model.Card;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends MongoRepository<Card, String> {
    List<Card> findAllByUserId(String userId);
}
