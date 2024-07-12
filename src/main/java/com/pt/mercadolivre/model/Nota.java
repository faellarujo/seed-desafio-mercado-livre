package com.pt.mercadolivre.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

public enum Nota {

    UM(1),
    DOIS(2),
    TRES(3),
    QUATRO(4),
    CINCO(5);

    private final int nota;

    Nota(int nota) {
        this.nota = nota;
    }

    public int getNota() {
        return nota;
    }
}
