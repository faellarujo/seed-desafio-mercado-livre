package com.pt.mercadolivre.Request;


import com.pt.mercadolivre.exception.senhaVazia;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class UsuarioRequest {


    @NotBlank
    @NotNull
    @Email
    private String login;

    private String senha;

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
           this.senha = validaSenha(senha);
       }


    public LocalDate getInstante() {
        return instante;
    }

    public void setInstante(LocalDate instante) {
        this.instante = instante;
    }

    public UsuarioRequest() {
    }

    public UsuarioRequest(@NotBlank @NotNull String login, String senha, @NotNull @PastOrPresent LocalDate instante) {
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

    private String validaSenha(String senha) {
        try {
            if (senha.length() < 6) {
                throw new senhaVazia("Senha deve ter no mínimo 6 caracteres");
            }
        } catch (NullPointerException e) {
            throw new senhaVazia("Senha não pode ser null");
        }
        return senha;
    }
}
