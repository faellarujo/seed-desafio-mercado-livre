package com.pt.mercadolivre.exception;

public class ProdutoNotExistException extends RuntimeException {
    public ProdutoNotExistException(String message) {
        super(message);
    }
}
