package com.pt.mercadolivre.model;

import jakarta.persistence.*;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    public Categoria(String nome) {
        this.nome = nome;
    }

    public Categoria() {
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
