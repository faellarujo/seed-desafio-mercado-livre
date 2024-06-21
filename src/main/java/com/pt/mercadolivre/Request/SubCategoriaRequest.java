package com.pt.mercadolivre.Request;

import com.pt.mercadolivre.model.Categoria;
import com.pt.mercadolivre.model.SubCategoria;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SubCategoriaRequest {

    @NotBlank
    private String nome;

    //@NotNull
    //@Valid
    private CategoriaRquest categoria;

    public SubCategoriaRequest(String nome) {
        this.nome = nome;
    }


    @Deprecated
    public SubCategoriaRequest() {
    }

    public SubCategoriaRequest(@NotBlank String nome, @Valid CategoriaRquest categoria) {
        this.nome = nome;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public CategoriaRquest getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaRquest categoria) {
        this.categoria = categoria;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    @Override
    public String toString() {
        return "SubCategoriaRequest{" +
                "nome='" + nome + '\'' +
                '}';
    }

    public SubCategoria toModel(Categoria categoria) {
        return new SubCategoria(this.nome, categoria);
    }
}
