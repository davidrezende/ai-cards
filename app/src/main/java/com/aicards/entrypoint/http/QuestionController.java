package com.aicards.entrypoint.http;

import com.aicards.entity.QuestionEntity;
import com.aicards.usecase.QuestionUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/question")
public class QuestionController {

    @Autowired
    private QuestionUseCase questionUseCase;

    @PostMapping
    private QuestionEntity saveQuestion(String question){
        return questionUseCase.saveQuestion(question);
    }

    @GetMapping("/all")
    private List<QuestionEntity> findAllQuestions(){
        return questionUseCase.findAllQuestions();
    }

    @GetMapping("/{questionId}")
    private QuestionEntity findQuestionByQuestionId(@PathVariable String questionId){
        return questionUseCase.findQuestionByQuestionId(questionId);
    }
}
