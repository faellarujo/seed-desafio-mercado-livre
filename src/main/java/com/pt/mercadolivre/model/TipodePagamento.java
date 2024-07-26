package com.pt.mercadolivre.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TipodePagamento {
    PAYPAL,
    PAGSEGURO;
}
