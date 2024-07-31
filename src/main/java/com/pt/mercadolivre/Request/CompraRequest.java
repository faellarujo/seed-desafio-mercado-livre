package com.pt.mercadolivre.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.pt.mercadolivre.model.*;
import com.pt.mercadolivre.util.TipodePagamentoDeserializer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.HashSet;
import java.util.Set;

public class CompraRequest {

    @NotNull
    private Long idProduto;

    @Positive
    private Integer quantidade;
    private User comprador;

    @JsonDeserialize(using = TipodePagamentoDeserializer.class)
    @Enumerated
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

    public Compra toModel(EntityManager entityManager, Produto produto, User comprador) {
        //Produto produto = entityManager.find(Produto.class, idProduto);
        Set<Produto> produtos = Set.of(produto);
        String gateway = this.gateway.toString();
        StatusDaCompra status = StatusDaCompra.INICIADA;
        return new Compra(gateway, produtos, comprador, status);

}}


