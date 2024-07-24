package com.pt.mercadolivre.views;

import com.pt.mercadolivre.model.Opiniao;

public class OpiniaoDoProdutoDetalheView {

        private String titulo;
        private String descricao;
        private int nota;

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public OpiniaoDoProdutoDetalheView(Opiniao opiniao) {
            this.titulo = opiniao.getTitulo();
            this.descricao = opiniao.getDescricao();
            this.nota = opiniao.getNota();
        }


}
