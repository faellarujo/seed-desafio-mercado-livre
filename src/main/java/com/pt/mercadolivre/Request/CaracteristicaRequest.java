package com.pt.mercadolivre.Request;

import com.pt.mercadolivre.model.Tamanho;

public class CaracteristicaRequest {

    // Pelo menos 03 atributos



    private Double peso;

    private String cor;

    private Tamanho tamanho;

    public CaracteristicaRequest(Double peso, String cor, Tamanho tamanho) {
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
        return "CaracteristicaRequest{" +
                "nome='" + peso + '\'' +
                ", cor='" + cor + '\'' +
                ", tamanho=" + tamanho +
                '}';
    }
}
