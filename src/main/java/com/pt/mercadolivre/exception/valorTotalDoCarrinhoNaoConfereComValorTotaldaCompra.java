package com.pt.mercadolivre.exception;

public class valorTotalDoCarrinhoNaoConfereComValorTotaldaCompra extends RuntimeException{
    public valorTotalDoCarrinhoNaoConfereComValorTotaldaCompra(String message) {
        super(message);
    }
}
