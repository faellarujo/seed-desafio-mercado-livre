package com.pt.mercadolivre.exception;

public class ProdutoExistException extends RuntimeException {
    public ProdutoExistException(String message) {
        super(message);
    }
}
