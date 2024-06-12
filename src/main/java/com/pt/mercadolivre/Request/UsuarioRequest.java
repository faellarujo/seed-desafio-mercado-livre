package com.pt.mercadolivre.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import org.hibernate.annotations.NotFound;

import java.time.LocalDate;

public class UsuarioRequest {


    @NotBlank
    String login;

    @NotBlank
    String senha;

    @NotNull
    @PastOrPresent
    LocalDate instante = LocalDate.now();

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getInstante() {
        return instante;
    }

    public void setInstante(LocalDate instante) {
        this.instante = instante;
    }

    public UsuarioRequest() {
    }

    public UsuarioRequest(@NotBlank String login, @NotBlank String senha, LocalDate instante) {
        this.login = login;
        this.senha = senha;
        this.instante = instante;
    }

    @Override
    public String toString() {
        return "UsuarioRequest{" +
                "login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", instante=" + instante +
                '}';
    }
}
