package com.example.stockmarketapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidApiKeyException.class)
    public ResponseEntity<String> handleInvalidApiKey(InvalidApiKeyException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(CompanyNotFoundException.class)
    public ResponseEntity<String> handleInvalidSymbol(CompanyNotFoundException na) {
        return new ResponseEntity<>(na.getMessage(), HttpStatus.NOT_FOUND);
    }
}
