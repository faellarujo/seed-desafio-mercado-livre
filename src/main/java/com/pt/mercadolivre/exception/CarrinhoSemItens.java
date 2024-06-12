package com.pt.mercadolivre.exception;

public class CarrinhoSemItens extends RuntimeException {
    public CarrinhoSemItens(String message) {
        super(message);
    }
}
