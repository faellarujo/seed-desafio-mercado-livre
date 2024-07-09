package com.pt.mercadolivre.Request;

import com.pt.mercadolivre.model.Caracteristica;
import com.pt.mercadolivre.model.Categoria;
import com.pt.mercadolivre.model.Produto;
import jakarta.persistence.EntityManager;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public class ProdutoRequest {

    @NotBlank
    private String nome;

    @NotNull
    @Min(1)
    private Double valor;

    @NotNull
    @Min(1)
    private Integer quantidade;

    @NotNull
    private Long idCaracteristica;

    @NotBlank
    @Size(max = 1000)
    private String descricao;

    @NotNull
    private Long idCategoria;

    @NotNull
    @PastOrPresent
    LocalDateTime instante = LocalDateTime.now();

    public ProdutoRequest() {
    }

    public ProdutoRequest(@NotBlank String nome, @NotNull @Min(1) Double valor, @NotNull @Min(1) Integer quantidade, @NotNull Long idCaracteristica, @NotBlank @Size(max = 1000) String descricao, @NotNull Long idCategoria, @NotNull @PastOrPresent LocalDateTime instante) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.idCaracteristica = idCaracteristica;
        this.descricao = descricao;
        this.idCategoria = idCategoria;
        this.instante = instante;
    }

    public @NotBlank String getNome() {
        return nome;
    }

    public void setNome(@NotBlank String nome) {
        this.nome = nome;
    }

    public @NotNull @Min(1) Double getValor() {
        return valor;
    }

    public void setValor(@NotNull @Min(1) Double valor) {
        this.valor = valor;
    }

    public @NotNull Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(@NotNull Integer quantidade) {
        this.quantidade = quantidade;
    }

    public @NotNull Long getIdCaracteristica() {
        return idCaracteristica;
    }

    public void setIdCaracteristica(@NotNull Long idCaracteristica) {
        this.idCaracteristica = idCaracteristica;
    }

    public @NotBlank @Size(max = 1000) String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotBlank @Size(max = 1000) String descricao) {
        this.descricao = descricao;
    }

    public @NotNull Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(@NotNull Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public @NotNull @PastOrPresent LocalDateTime getInstante() {
        return instante;
    }

    public void setInstante(@NotNull @PastOrPresent LocalDateTime instante) {
        this.instante = instante;
    }


    @Override
    public String toString() {
        return "ProdutoRequest{" +
                "nome='" + nome + '\'' +
                ", valor=" + valor +
                ", quantidade=" + quantidade +
                ", caracteristica=" + idCaracteristica +
                ", descricao='" + descricao + '\'' +
                ", idCategoria=" + idCategoria +
                ", instante=" + instante +
                '}';
    }

    public Produto toModel(EntityManager manager) {
        return new Produto(nome, valor, quantidade, manager.find(Caracteristica.class, idCaracteristica), descricao, manager.find(Categoria.class, idCategoria), instante);

    }
}
