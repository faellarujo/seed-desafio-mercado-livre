package com.pt.mercadolivre.Request;


import com.pt.mercadolivre.exception.senhaVazia;
import com.pt.mercadolivre.model.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UsuarioRequest {


    @NotBlank
    @NotNull
    @Email
    private String login;

    @NotBlank
    @Length(min = 6)
    private String senha;

    @NotNull
    @PastOrPresent
    LocalDateTime instante = LocalDateTime.now();

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


    public LocalDateTime getInstante() {
        return instante;
    }

    public void setInstante(LocalDateTime instante) {
        this.instante = instante;
    }

    public UsuarioRequest() {
    }

    public UsuarioRequest(@NotBlank @NotNull String login, @NotBlank @Length(min = 6) String senha, @NotNull @PastOrPresent LocalDateTime instante) {
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

    public Usuario toModel() {
        return new Usuario(this.login, this.senha, this.instante);
    }
}
