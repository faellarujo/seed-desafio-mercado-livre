package com.pt.mercadolivre.views;

import com.pt.mercadolivre.model.Produto;
import com.pt.mercadolivre.model.User;

import java.math.BigDecimal;
import java.util.Optional;

public class DetalesDoProdutoView {

    private String descricao;
    private String nome;
    private BigDecimal valor;
    private String categoria;
    private Long idUser;
    private String userName;

    public DetalesDoProdutoView(Produto produto) {
        setProduto(produto);
    }

    public void setProduto(Produto produto) {
        this.descricao = produto.getDescricao();
        this.nome = produto.getNome();
        this.valor = produto.getValor();
        this.categoria = produto.getCategoria().getNome();
        this.idUser = Optional.ofNullable(produto.getUser()).map(User::getId).orElse(0L);
        this.userName = Optional.ofNullable(produto.getUser()).map(User::getUsername).orElse("");
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Long getIdUser() { return idUser;
    }

    public void setIdUser(Long idUser) { this.idUser = idUser;
    }

    public String getUserName() { return userName;
    }

    public void setUserName(String userName) { this.userName = userName;
    }
}
