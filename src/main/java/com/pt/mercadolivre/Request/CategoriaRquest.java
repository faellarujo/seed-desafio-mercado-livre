package com.pt.mercadolivre.Request;

import com.pt.mercadolivre.model.Categoria;
import com.pt.mercadolivre.validadores.UniqueValue;
import jakarta.validation.constraints.NotBlank;

public class CategoriaRquest {

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CategoriaRquest() {
    }

    public CategoriaRquest(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "CategoriaRquest{" +
                "nome='" + nome + '\'' +
                '}';
    }

    public Categoria toModel(){
        return new Categoria(this.nome);
    }
}
