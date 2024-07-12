package com.pt.mercadolivre.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.pt.mercadolivre.exception.InvalidNotavalue;
import com.pt.mercadolivre.exception.Notavaluemustbebetween1and5;
import com.pt.mercadolivre.model.Nota;

import java.io.IOException;

public class NotaDeserializer extends JsonDeserializer<Nota> {

    @Override
    public Nota deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        int notaValue = jsonParser.getIntValue();
        if (notaValue < 1 || notaValue > 5) {
            throw new Notavaluemustbebetween1and5("Nota value must be between 1 and 5");
        }
        for (Nota nota : Nota.values()) {
            if (nota.getNota() == notaValue) {
                return nota;
            }
        }
        throw new InvalidNotavalue("Invalid Nota value: " + notaValue);
    }
}
