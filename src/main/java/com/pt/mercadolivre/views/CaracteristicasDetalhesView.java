package com.pt.mercadolivre.views;

import com.pt.mercadolivre.model.Caracteristica;

public class CaracteristicasDetalhesView {

    private String nome;
    private String descricao;


    CaracteristicasDetalhesView(Caracteristica caracteristica) {
        this.nome = caracteristica.getNome();
        this.descricao = caracteristica.getDescricao();

    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }


}
