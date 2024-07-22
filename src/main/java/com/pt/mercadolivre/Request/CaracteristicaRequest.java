package com.pt.mercadolivre.Request;

import com.pt.mercadolivre.model.Caracteristica;
import com.pt.mercadolivre.model.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class CaracteristicaRequest {

    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;

    public CaracteristicaRequest() {
    }

    public CaracteristicaRequest(@NotBlank String nome, @NotBlank String descricao) {
        super();
        this.nome = nome;
        this.descricao = descricao;
    }


    public @NotBlank String getNome() {
        return nome;
    }

    public void setNome(@NotBlank String nome) {
        this.nome = nome;
    }

    public @NotBlank String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotBlank String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "CaracteristicaRequest{" +
                "descricao='" + descricao + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }

    public Caracteristica toModel(Produto produto){
        return new Caracteristica(nome, descricao, produto);
    }
}
