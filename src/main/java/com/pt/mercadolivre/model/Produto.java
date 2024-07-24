package com.pt.mercadolivre.model;

import com.pt.mercadolivre.Request.CaracteristicaRequest;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


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


    @OneToMany(mappedBy = "produto", cascade = CascadeType.PERSIST)
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

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private List<Opiniao> opinioes = new ArrayList<>();

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private List<Pergunta> perguntas = new ArrayList<>();


    public Produto() {
    }

//    public Produto(String nome, BigDecimal valor, Integer quantidade, Set<Caracteristica> caracteristica, String descricao, Categoria categoria, LocalDateTime instante, ImagemProduto linkImagem, User user) {
//        this.nome = nome;
//        this.valor = valor;
//        this.quantidade = quantidade;
//        this.caracteristica = caracteristica;
//        this.descricao = descricao;
//        this.categoria = categoria;
//        this.instante = instante;
//        this.linkImagem.add(linkImagem);
//        this.user = user;
//
//    }

    public Produto(String nome, BigDecimal valor, Integer quantidade, List<Caracteristica> caracteristica, String descricao, Categoria categoria, LocalDateTime instante, User user) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.caracteristica.addAll(caracteristica.stream().map(caracteristica1 -> new Caracteristica(caracteristica1.getNome(), caracteristica1.getDescricao(), this)).collect(Collectors.toSet()));
        this.descricao = descricao;
        this.categoria = categoria;
        this.instante = instante;
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

    public List<Opiniao> getOpinioes() {
        return opinioes;
    }

    public void setOpinioes(List<Opiniao> opinioes) {
        this.opinioes = opinioes;
    }

    public List<Pergunta> getPerguntas() {
        return perguntas;
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

