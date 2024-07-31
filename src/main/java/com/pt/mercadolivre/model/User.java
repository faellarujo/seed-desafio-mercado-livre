package com.pt.mercadolivre.model;

import jakarta.persistence.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User{

    /**
     * @param Email string no formato de Email
     * @param senha string em texto limpo
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Opiniao> opinioes = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "compra_id")
    private List<Compra> compra;

    public void setOpinioes(List<Opiniao> opinioes) {
        this.opinioes = opinioes;
    }

    public User() {
    }


    public User(String username, String password) {
        this.username = username;
        this.password = new BCryptPasswordEncoder().encode(password);
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Opiniao> getOpinioes() {
        return opinioes;
    }
}
