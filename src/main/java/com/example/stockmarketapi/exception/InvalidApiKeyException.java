package com.example.stockmarketapi.exception;

public class InvalidApiKeyException extends RuntimeException {

    public InvalidApiKeyException() {
        super("Invalid API Key provided.");
    }

    public InvalidApiKeyException(String message) {
        super(message);
    }

    public InvalidApiKeyException(String message, Throwable cause) {
        super(message, cause);
    }
}
