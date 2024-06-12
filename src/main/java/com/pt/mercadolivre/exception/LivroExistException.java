package com.pt.mercadolivre.exception;

public class LivroExistException extends RuntimeException{
    public LivroExistException(String message) {
        super(message);
    }
}
