package com.example.java.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message, Throwable cause){
        super(message,cause);
    }
}
