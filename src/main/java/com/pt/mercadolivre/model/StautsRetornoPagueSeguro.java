package com.pt.mercadolivre.model;

public enum StautsRetornoPagueSeguro {

    SUCESSO, ERRO;

    public StatusDaCompra normaliza() {
        if(this.equals(SUCESSO)) {
            return StatusDaCompra.SUCESSO;
        }
        return StatusDaCompra.ERRO;
    }
}
