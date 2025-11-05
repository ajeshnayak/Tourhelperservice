package com.tourhelper.tourhelperservice.controller.advice;

import com.tourhelper.tourhelperservice.exception.AccountAlreadyExistException;
import com.tourhelper.tourhelperservice.exception.InvalidArgumentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonControllerAdvice {

    @ExceptionHandler(AccountAlreadyExistException.class)
    public ResponseEntity<String> AccountAlreadyExistException(AccountAlreadyExistException ex){
        return new ResponseEntity<>( ex.getMessage(), HttpStatus.OK);
    }
    @ExceptionHandler(InvalidArgumentException.class)
    public ResponseEntity<String> InvalidArgumentException(InvalidArgumentException ex){
        return new ResponseEntity<>( ex.getMessage(), HttpStatus.OK);
    }
}
