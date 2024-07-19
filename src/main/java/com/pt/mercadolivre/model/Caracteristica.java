package com.pt.mercadolivre.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Caracteristica {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "peso")
    private String nome;

    @Column(name = "cor")
    private String descricao;


    public Caracteristica() {
    }

    public Caracteristica(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome () {
        return nome;
    }

    public void setNome (String nome){
        this.nome = nome;
    }

    public String getDescricao () {
        return descricao;
    }

    public void setDescricao (String descricao){
        this.descricao = descricao;
    }

}


