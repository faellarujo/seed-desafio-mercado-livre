package com.pt.mercadolivre.views;

import com.pt.mercadolivre.model.Pergunta;

public class PerguntasAoVendedorView {

    private String titulo;
    private String descricao;
    private String nomeUsuario;


    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public PerguntasAoVendedorView(Pergunta pergunta) {
        this.titulo = pergunta.getTitulo();
        this.descricao = pergunta.getDescricao();
        this.nomeUsuario = pergunta.getUsuario().getUsername();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

}
