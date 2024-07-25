package com.pt.mercadolivre.Request;

import com.pt.mercadolivre.model.TipodePagamento;
import com.pt.mercadolivre.model.User;
import jakarta.validation.constraints.NotNull;

public class CompraRequest {


    private Long idProduto;

    @NotNull
    private Integer quantidade;
    private User comprador;
    private TipodePagamento gateway;

    public void setGateway(TipodePagamento gateway) {
        this.gateway = gateway;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setComprador(User comprador) {
        this.comprador = comprador;
    }

    public CompraRequest() {
    }

    public CompraRequest(Long idProduto, Integer quantidade, String gateway, User comprador, TipodePagamento tipodePagamento) {
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.gateway = tipodePagamento;
        this.comprador = comprador;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public TipodePagamento getGateway() {
        return gateway;
    }

    @Override
    public String toString() {
        return "CompraRequest{" +
                "comprador=" + comprador +
                ", idProduto=" + idProduto +
                ", quantidade=" + quantidade +
                ", gateway=" + gateway +
                '}';
    }

    public User getComprador() {
        return comprador;
    }

    public TipodePagamento getGateway1() {
        return gateway;
    }


}
