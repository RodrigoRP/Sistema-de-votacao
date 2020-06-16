package com.rodrigoramos.sistemavotacaoapi.service.exception;

public class CustomerRegistrationException extends RuntimeException {

    public CustomerRegistrationException(String message) {
        super(message);
    }
}
