package com.wiwats.shopping.errorHandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@Slf4j
@RestControllerAdvice
public class UserControllerAdvice {


     @ExceptionHandler(UserDataIncorrectException.class)
     @ResponseBody
     @ResponseStatus(HttpStatus.BAD_REQUEST)
     public ErrorMessage userDataIncorrect(UserDataIncorrectException e){
         ErrorMessage errorMessage = new ErrorMessage();
         errorMessage.setMessage(e.getMessage());

         log.error("UserControllerAdvice - "+ String.valueOf(errorMessage));
         return  errorMessage;
    }
}
