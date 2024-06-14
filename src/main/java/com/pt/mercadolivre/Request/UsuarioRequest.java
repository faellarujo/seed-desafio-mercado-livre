package com.pt.mercadolivre.Request;

import com.pt.mercadolivre.exception.senhaVazia;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import javax.swing.*;
import java.time.LocalDate;

public class UsuarioRequest {


    @NotBlank
    @NotNull
    @Email
    private String login;


    private char[] senha;

    @NotNull
    @PastOrPresent
    LocalDate instante = LocalDate.now();

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public char[] getSenha() {
        return senha;
    }

    public void setSenha(char[] senha) {
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

    public UsuarioRequest(@NotBlank @NotNull String login, char[] senha, @NotNull @PastOrPresent LocalDate instante) {
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

    private char[] validaSenha(char[] senha) {
        try {
            if (senha.length < 6) {
                throw new senhaVazia("Senha deve ter no mínimo 6 caracteres");
            }
        } catch (NullPointerException e) {
            throw new senhaVazia("Senha não pode ser null");
        }
        return senha;
    }
}
