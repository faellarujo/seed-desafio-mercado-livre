package com.pt.mercadolivre.model;

import jakarta.persistence.*;
import jdk.jfr.Enabled;

import java.time.LocalDateTime;


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

    public Produto() {
    }

//    public Produto(Long id, String nome, Double valor, Integer quantidade, Caracteristica caracteristica, String descricao, Categoria categoria, LocalDateTime instante) {
//        this.id = id;
//        this.nome = nome;
//        this.valor = valor;
//        this.quantidade = quantidade;
//        this.caracteristica = caracteristica;
//        this.descricao = descricao;
//        this.categoria = categoria;
//        this.instante = instante;
//    }



        public Produto(String nome, Double valor, Integer quantidade, Caracteristica caracteristica, String descricao, Categoria categoria, LocalDateTime instante) {
            this.id = id;
            this.nome = nome;
            this.valor = valor;
            this.quantidade = quantidade;
            this.caracteristica = caracteristica;
            this.descricao = descricao;
            this.categoria = categoria;
            this.instante = instante;
        }



}

