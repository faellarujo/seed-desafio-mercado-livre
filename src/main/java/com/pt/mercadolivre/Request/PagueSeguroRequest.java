package com.pt.mercadolivre.Request;

import com.pt.mercadolivre.model.StautsRetornoPagueSeguro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PagueSeguroRequest {

    @NotBlank
    private String idTransacao;

    @NotNull
    private StautsRetornoPagueSeguro status;

    public PagueSeguroRequest(@NotNull  String idTransacao, StautsRetornoPagueSeguro status) {
        this.idTransacao = idTransacao;
        this.status = status;
    }

    public String getIdTransacao() {
        return idTransacao;
    }

    public StautsRetornoPagueSeguro getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "PagueSeguroRequest{" +
                "idTransacao='" + idTransacao + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
