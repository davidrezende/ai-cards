package com.aicards.usecase;

import com.aicards.dataprovider.QuestionDataProvider;
import com.aicards.entity.QuestionEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class QuestionUseCase {

    private final QuestionDataProvider questionDataProvider;

    public QuestionUseCase(QuestionDataProvider questionDataProvider) {
        this.questionDataProvider = questionDataProvider;
    }

    public QuestionEntity saveQuestion(String question){

        QuestionEntity questionEntity = new QuestionEntity(
                UUID.randomUUID().toString(),
                LocalDate.now(),
                question
        );

        return questionDataProvider.saveQuestion(questionEntity);
    }

    public List<QuestionEntity> findAllQuestions(){
        return questionDataProvider.findAllQuestions();
    }

    public QuestionEntity findQuestionByQuestionId(String questionId){
        return questionDataProvider.findQuestionByQuestionId(questionId);
    }
}
