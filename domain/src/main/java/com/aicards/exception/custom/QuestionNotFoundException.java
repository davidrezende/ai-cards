package com.aicards.exception.custom;

public class QuestionNotFoundException extends RuntimeException{
    public QuestionNotFoundException(String errorMessage) {
        super(errorMessage);
    }

    public QuestionNotFoundException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}
