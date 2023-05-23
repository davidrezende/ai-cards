package com.aicards.exception.custom;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String errorMessage) {
        super(errorMessage);
    }

    public UserNotFoundException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}
