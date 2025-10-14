package com.enenzz.javase.exception.test2;

public class NameException extends RuntimeException{
    public NameException() {

    }

    public NameException(String message) {
        super(message);
    }
}
