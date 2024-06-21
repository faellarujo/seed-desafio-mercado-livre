package com.pt.mercadolivre.model;


import jakarta.persistence.*;

@Entity(name = "subcategoria")
public class SubCategoria {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @ManyToOne
    private Categoria categoria;

    public SubCategoria(String nome, Categoria categoria) {
        this.nome = nome;
        this.categoria = categoria;
    }

    @Deprecated
    public SubCategoria() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "SubCategoria{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
