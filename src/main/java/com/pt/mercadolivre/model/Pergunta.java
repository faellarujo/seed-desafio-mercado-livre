package com.pt.mercadolivre.model;

import jakarta.persistence.*;

@Entity
public class Pergunta {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String titulo;

    @Column
    private String descricao;

    @ManyToOne
    private User usuario;

    @ManyToOne
    private Vendedor vendedor;

    @ManyToOne
    private Produto produto;

    public Produto getProduto() {
        return produto;
    }

    public Pergunta() {
    }

    public Pergunta(String titulo, String descricao, User usuario, Vendedor vendedor, Produto produto) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.usuario = usuario;
        this.vendedor = vendedor;
        this.produto = produto;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public User getUsuario() {
        return usuario;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }


    @Override
    public String toString() {
        return "Pergunta{" +
                "titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", usuario=" + usuario +
                ", vendedor=" + vendedor +
                '}';
    }

}
