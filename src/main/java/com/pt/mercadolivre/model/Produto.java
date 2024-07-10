package com.pt.mercadolivre.model;

import jakarta.persistence.*;
import jdk.jfr.Enabled;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "valor")
    private Double valor;

    @Column(name = "quantidade")
    private Integer quantidade;


    @OneToOne(cascade = CascadeType.ALL)
    private Caracteristica caracteristica;

    @Column(name = "descricao")
    private String descricao;


    @ManyToOne(cascade = CascadeType.ALL)
    private Categoria categoria;

    @Column(name = "instante")
    private LocalDateTime instante = LocalDateTime.now();

    @Column(name = "linkImagem")
    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private List<ImagemProduto> linkImagem = new ArrayList<>();

    public Produto() {
    }


    public Produto(String nome, Double valor, Integer quantidade, Caracteristica caracteristica, String descricao, Categoria categoria, LocalDateTime instante, ImagemProduto linkImagem) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.caracteristica = caracteristica;
        this.descricao = descricao;
        this.categoria = categoria;
        this.instante = instante;
        this.linkImagem.add(linkImagem);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Caracteristica getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(Caracteristica caracteristica) {
        this.caracteristica = caracteristica;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public LocalDateTime getInstante() {
        return instante;
    }

    public void setInstante(LocalDateTime instante) {
        this.instante = instante;
    }

    public List<ImagemProduto> getLinkImagem() {
        return linkImagem;
    }

    public void setLinkImagem(List<ImagemProduto> linkImagem) {
        this.linkImagem = linkImagem;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", valor=" + valor +
                ", quantidade=" + quantidade +
                ", caracteristica=" + caracteristica +
                ", descricao='" + descricao + '\'' +
                ", categoria=" + categoria +
                ", instante=" + instante +
                ", linkImagem=" + linkImagem +
                '}';
    }
}

