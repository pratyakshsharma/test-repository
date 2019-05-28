package com.paypay.exception;

public class CustomStackException extends RuntimeException {

    public CustomStackException() {
        super();
    }

    public CustomStackException(String message) {
        super(message);
    }
}
