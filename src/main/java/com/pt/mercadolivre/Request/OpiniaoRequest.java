package com.pt.mercadolivre.Request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.pt.mercadolivre.model.Nota;
import com.pt.mercadolivre.util.NotaDeserializer;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public class OpiniaoRequest {

    @NotNull
    @JsonDeserialize(using = NotaDeserializer.class)
    private Nota nota;

    @NotBlank
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String descricao;

    @NotNull
    private Long idProduto;

    @NotNull
    private Long idUsuario;

    public OpiniaoRequest() {
    }

    public OpiniaoRequest(Nota nota, String titulo, String descricao, Long idProduto, Long idUsuario) {
        this.nota = nota;
        this.titulo = titulo;
        this.descricao = descricao;
        this.idProduto = idProduto;
        this.idUsuario = idUsuario;
    }

    public Nota getNota() {
        return nota;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    @Override
    public String toString() {
        return "OpiniaoRequest{" +
                "nota=" + nota +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", idProduto=" + idProduto +
                ", idUsuario=" + idUsuario +
                '}';
    }

}


