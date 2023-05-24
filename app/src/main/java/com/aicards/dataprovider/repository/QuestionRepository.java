package com.aicards.dataprovider.repository;

import com.aicards.dataprovider.model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends MongoRepository<Question, String> {
    Question findByQuestionId(String questionId);
}
