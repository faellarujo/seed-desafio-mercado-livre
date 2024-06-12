package com.pt.mercadolivre.exception;

public class PaisExistException extends RuntimeException{
    public PaisExistException(String message) {
        super(message);
    }
}
