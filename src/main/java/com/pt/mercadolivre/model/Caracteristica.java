package com.pt.mercadolivre.model;


import jakarta.persistence.*;

@Entity
public class Caracteristica {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "peso")
    private Double peso;

    @Column(name = "cor")
    private String cor;

    @Column(name = "tamanho")
    @Enumerated(EnumType.STRING)
    private Tamanho tamanho;



    public Caracteristica() {
    }


    public Caracteristica(Double peso, String cor, Tamanho tamanho) {
        this.peso = peso;
        this.cor = cor;
        this.tamanho = tamanho;
    }

    public Double getPeso () {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return "Caracteristica{" +
                "nome='" + peso + '\'' +
                ", cor='" + cor + '\'' +
                ", tamanho=" + tamanho +
                '}';
    }

}
