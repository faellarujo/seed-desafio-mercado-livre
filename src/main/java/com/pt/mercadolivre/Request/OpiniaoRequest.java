package com.pt.mercadolivre.Request;

import com.pt.mercadolivre.exception.ProdutoNotExistException;
import com.pt.mercadolivre.exception.UserNotExistException;
import com.pt.mercadolivre.model.Opiniao;
import com.pt.mercadolivre.model.Produto;
import com.pt.mercadolivre.model.User;
import jakarta.persistence.EntityManager;
import jakarta.validation.constraints.*;

import java.util.Optional;

public class OpiniaoRequest {

    @NotNull
    @Min(1)
    @Max(5)
    private int nota;

    @NotBlank
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String descricao;

    @NotNull
    private Long idUsuario;

    public OpiniaoRequest() {
    }

    public OpiniaoRequest(int nota, String titulo, String descricao, Long idUsuario) {
        this.nota = nota;
        this.titulo = titulo;
        this.descricao = descricao;
        this.idUsuario = idUsuario;
    }

    public int getNota() {
        return nota;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
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
                ", idUsuario=" + idUsuario +
                '}';
    }

    public Opiniao toModel(Produto produto, User usuario) {
        return new Opiniao(titulo, descricao, nota, produto, usuario);
    }

}


