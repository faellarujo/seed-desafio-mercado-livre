package com.pt.mercadolivre.model;

import jakarta.persistence.*;
import jdk.jfr.Enabled;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "valor")
    private BigDecimal valor;

    @Column(name = "quantidade")
    private Integer quantidade;


    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Caracteristica> caracteristica = new HashSet<>();

    @Column(name = "descricao")
    private String descricao;


    @ManyToOne(cascade = CascadeType.ALL)
    private Categoria categoria;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    @Column(name = "instante")
    private LocalDateTime instante = LocalDateTime.now();

    @Column(name = "linkImagem")
    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private List<ImagemProduto> linkImagem = new ArrayList<>();


    public Produto() {
    }

    public Produto(String nome, BigDecimal valor, Integer quantidade, Set<Caracteristica> caracteristica, String descricao, Categoria categoria, LocalDateTime instante, ImagemProduto linkImagem, User user) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.caracteristica = caracteristica;
        this.descricao = descricao;
        this.categoria = categoria;
        this.instante = instante;
        this.linkImagem.add(linkImagem);
        this.user = user;


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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Set<Caracteristica> getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(Set<Caracteristica> caracteristica) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
                ", user=" + user +
                '}';
    }

}

