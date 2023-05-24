package com.aicards.dataprovider;

import com.aicards.dataprovider.model.Question;
import com.aicards.dataprovider.repository.QuestionRepository;
import com.aicards.entity.QuestionEntity;
import com.aicards.exception.custom.QuestionNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestionMongoProvider implements QuestionDataProvider {

    @Autowired
    private QuestionRepository repository;

    @Override
    public QuestionEntity saveQuestion(QuestionEntity questionEntity) {
        return repository.save(new Question().toQuestion(questionEntity)).toEntity();
    }

    @Override
    public List<QuestionEntity> findAllQuestions() {
        return repository.findAll().stream().map(Question::toEntity).toList();
    }

    @Override
    public QuestionEntity findQuestionByQuestionId(String questionId) {
        Question question = repository.findByQuestionId(questionId);
        if(question == null) throw new QuestionNotFoundException("Pergunta: " + "\"" + questionId + "\"" + " não encontrada.");
        return question.toEntity();
    }
}
