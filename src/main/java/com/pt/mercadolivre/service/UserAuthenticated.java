package com.pt.mercadolivre.service;

import com.pt.mercadolivre.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * preciso de um cara para encapsular um usuario autenticado. esse cara deve implementar a interface UserDetails
 * Depois preciso de um serviço que vai trabalhar com essa entidade
 */


public class UserAuthenticated implements UserDetails {
    /**
     * Preciso instanciar o usuario porque preciso pegar informações desse cara
     */


    private User user;


    public UserAuthenticated(User user) {
        this.user = user;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { // Aqui eu pego as autorizações do usuario ou papéis
        return List.of( () -> "ROLE_USER");
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
