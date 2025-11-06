package com.tourhelper.tourhelperservice.exception;

public class AccountDoesnotExistException extends RuntimeException {
    public AccountDoesnotExistException(String message) {
        super(message);
    }
}
