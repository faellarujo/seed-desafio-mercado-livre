package com.pt.mercadolivre.model;

public class Transacao {

    private Long id;
    private StautsRetornoPagueSeguro status;
    private String transacaoId;

    public Transacao(StautsRetornoPagueSeguro status, String transacaoId) {
        this.status = status;
        this.transacaoId = transacaoId;
    }

    public Long getId() {
        return id;
    }

    public StautsRetornoPagueSeguro getStatus() {
        return status;
    }

    public String getCompraId() {
        return transacaoId;
    }
}
