package com.pt.mercadolivre.Request;


import com.pt.mercadolivre.model.User;
import com.pt.mercadolivre.model.User;
import com.pt.mercadolivre.validadores.UniqueValue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public class UsuarioRequest {


    @NotBlank
    @NotNull
    @Email
    @UniqueValue(domainClass = User.class, fieldName = "username")
    private String username;

    @NotBlank
    @Length(min = 6)
    private String password;

    @NotNull
    @PastOrPresent
    LocalDateTime instante = LocalDateTime.now();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
           this.password = password;
       }


    public LocalDateTime getInstante() {
        return instante;
    }

    public void setInstante(LocalDateTime instante) {
        this.instante = instante;
    }

    public UsuarioRequest() {
    }

    public UsuarioRequest(@NotBlank @NotNull String username, @NotBlank @Length(min = 6) String password, @NotNull @PastOrPresent LocalDateTime instante) {
        this.username = username;
        this.password = password;
        this.instante = instante;
    }

    @Override
    public String toString() {
        return "UsuarioRequest{" +
                "login='" + username + '\'' +
                ", senha='" + password + '\'' +
                ", instante=" + instante +
                '}';
    }

    public User toModel() {
        return new User(username, password);
    }
}
