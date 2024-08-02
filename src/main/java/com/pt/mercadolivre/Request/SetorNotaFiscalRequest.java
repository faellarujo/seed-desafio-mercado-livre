package com.pt.mercadolivre.Request;

import com.pt.mercadolivre.model.Compra;
import jakarta.validation.constraints.NotNull;

public class SetorNotaFiscalRequest {

    @NotNull
    private Long idCompra;

    @NotNull
    private Long idUsuario;

    public Long getIdCompra() {
        return idCompra;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdCompra(Long idCompra) {
        this.idCompra = idCompra;
    }

    public SetorNotaFiscalRequest() {
    }

    public void setIdUsuario(Long idUsuario, Long idCompra) {
        this.idUsuario = idUsuario;
        this.idCompra = idCompra;
    }

    @Override
    public String toString() {
        return "SetorNotaFiscalRequest{" +
                "idCompra=" + idCompra +
                ", idUsuario=" + idUsuario +
                '}';
    }

    private void comunicaAoSetoDeNotasFiscais(Compra compra) {

    }



}


