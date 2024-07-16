package com.pt.mercadolivre.Request;

import com.pt.mercadolivre.model.Pergunta;
import com.pt.mercadolivre.model.Produto;
import com.pt.mercadolivre.model.User;
import com.pt.mercadolivre.model.Vendedor;
import jakarta.persistence.EntityManager;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.security.core.Authentication;

import java.time.LocalDateTime;

public class PerquntaRequest {

    @NotBlank
    private String titulo;

    @NotBlank
    private String descricao;

    private LocalDateTime instanteCriacao = LocalDateTime.now();

    @NotNull
    private Long idUsuario;

    @NotNull
    private Long idProduto;

    @NotNull
    private Long idVendedor;

    public PerquntaRequest() {
    }

    public PerquntaRequest(String titulo, String descricao, LocalDateTime instanteCriacao, Long idUsuario, Long idProduto, Long idVendedor) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.instanteCriacao = instanteCriacao;
        this.idUsuario = idUsuario;
        this.idProduto = idProduto;
        this.idVendedor = idVendedor;
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDateTime getInstanteCriacao() {
        return instanteCriacao;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public Long getIdVendedor() {
        return idVendedor;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public void setIdVendedor(Long idVendedor) {
        this.idVendedor = idVendedor;
    }

    public void setInstanteCriacao(LocalDateTime instanteCriacao) {
        this.instanteCriacao = instanteCriacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "PerquntaRequest{" +
                "titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", instanteCriacao=" + instanteCriacao +
                ", idUsuario=" + idUsuario +
                ", idProduto=" + idProduto +
                ", idVendedor=" + idVendedor +
                '}';

    }

    public Pergunta toModel(Produto produto, Vendedor vendedor, User user) {
        return new Pergunta(titulo, descricao, user, vendedor);
    }


}
