package com.pt.mercadolivre.Request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class ProdutoRequest {

    @NotBlank
    private String nome;

    @NotNull
    @Min(1)
    private Double valor;

    @NotNull
    private Integer quantidade;

    @NotNull
    @Valid
    private CaracteristicaRequest caracteristica;

    @NotBlank
    @Size(max = 1000)
    private String descricao;

    @NotNull
    private Long idCategoria;

    @NotNull
    @PastOrPresent
    LocalDateTime instante = LocalDateTime.now();

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

    public @NotNull @Valid CaracteristicaRequest getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(@NotNull @Valid CaracteristicaRequest caracteristica) {
        this.caracteristica = caracteristica;
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
                ", caracteristica=" + caracteristica +
                ", descricao='" + descricao + '\'' +
                ", idCategoria=" + idCategoria +
                ", instante=" + instante +
                '}';
    }
}
