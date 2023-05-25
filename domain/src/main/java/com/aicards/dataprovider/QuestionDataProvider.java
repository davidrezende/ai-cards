package com.aicards.dataprovider;

import com.aicards.entity.QuestionEntity;

import java.util.List;

public interface QuestionDataProvider {
    QuestionEntity saveQuestion(QuestionEntity questionEntity);
    List<QuestionEntity> findAllQuestions();
    QuestionEntity findQuestionByQuestionId(String questionId);
}
