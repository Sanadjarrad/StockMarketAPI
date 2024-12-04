package com.example.stockmarketapi.exception;

public class CompanyNotFoundException extends Throwable {

    public CompanyNotFoundException() {
        super("This symbol corresponds to an organisation that is not supported by this API");
    }

    public CompanyNotFoundException(String message) {
        super(message);
    }

    public CompanyNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
