package com.pt.mercadolivre.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.pt.mercadolivre.exception.TipoDePagamentoInexistente;
import com.pt.mercadolivre.model.TipodePagamento;

import java.io.IOException;

public class TipodePagamentoDeserializer extends JsonDeserializer<TipodePagamento> {

    @Override
    public TipodePagamento deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.getValueAsString();
        try {
            return TipodePagamento.valueOf(value);
        } catch (IllegalArgumentException e) {
            throw new TipoDePagamentoInexistente("Opção de pagamento inexistente: " + value);
        }
    }
}