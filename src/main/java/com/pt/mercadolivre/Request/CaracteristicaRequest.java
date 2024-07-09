package com.pt.mercadolivre.Request;

import com.pt.mercadolivre.model.Caracteristica;
import com.pt.mercadolivre.model.Tamanho;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CaracteristicaRequest {

    // Pelo menos 03 atributos


    @NotNull
    private Double peso;

    @NotBlank
    private String cor;

    @NotNull
    private Tamanho tamanho;

    public CaracteristicaRequest() {
    }

    public CaracteristicaRequest(@NotNull Double peso, @NotBlank String cor, @NotNull Tamanho tamanho) {
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

    public Caracteristica toModel() {
        return new Caracteristica(peso, cor, tamanho);
    }
}
