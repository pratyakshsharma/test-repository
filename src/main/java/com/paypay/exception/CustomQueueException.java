package com.paypay.exception;

public class CustomQueueException extends RuntimeException {

    public CustomQueueException() {
        super();
    }

    public CustomQueueException(String message) {
        super(message);
    }
}
