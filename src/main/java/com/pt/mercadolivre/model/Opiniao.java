package com.pt.mercadolivre.model;


import jakarta.persistence.*;

@Entity
public class Opiniao {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;


    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "nota")
    private int nota;

    @ManyToOne(cascade = CascadeType.ALL)
    private Produto produto;

    @ManyToOne(cascade = CascadeType.ALL)
    private User usuario;


    public Opiniao() {
    }

    public Opiniao(String titulo, String descricao, int nota, Produto produto,  User usuario) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.nota = nota;
        this.produto = produto;
        this.usuario = usuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getNota() {
        return nota;
    }

    public Produto getProduto() {
        return produto;
    }

    public  User getUsuario() {
        return usuario;
    }

    @Override
    public String toString() {
        return "Opiniao{" +
                "titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", nota=" + nota +
                ", produto=" + produto +
                ", usuario=" + usuario +
                '}';
    }


}
