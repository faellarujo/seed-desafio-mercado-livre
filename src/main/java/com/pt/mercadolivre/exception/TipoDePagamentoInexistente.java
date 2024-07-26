package com.pt.mercadolivre.exception;

public class TipoDePagamentoInexistente extends RuntimeException{
    public TipoDePagamentoInexistente(String message) {
        super(message);
    }
}
