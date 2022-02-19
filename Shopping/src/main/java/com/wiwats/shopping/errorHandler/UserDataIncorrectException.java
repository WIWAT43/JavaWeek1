package com.wiwats.shopping.errorHandler;

public class UserDataIncorrectException extends RuntimeException{
    public UserDataIncorrectException(String message){
        super(message);
    }
}
