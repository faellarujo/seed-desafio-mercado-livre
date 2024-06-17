package com.pt.mercadolivre.model;

import jakarta.persistence.*;

@Entity
public class Usuario {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;


        @Column(name = "login", nullable = false, unique = true)
        private String login;

        @Column(name = "senha", nullable = false)
        private String senha;

        public Usuario(String login, String senha) {
            this.login = login;
            this.senha = senha;
        }

        public String getLogin() {
            return login;
        }

        public String getSenha() {
            return senha;
        }
}
