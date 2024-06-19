package com.pt.mercadolivre.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;

@Entity
public class Usuario {

    /**
     * @param Email string no formato de Email
     * @param senha string em texto limpo
     */

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;


        @Column(name = "login", nullable = false, unique = true)
        private String login;

        @Column(name = "senha", nullable = false)
        private String senha;

        @Column(name = "instante", nullable = false)
        LocalDateTime instante = LocalDateTime.now();

        public Usuario() {
        }


        public Usuario(String login, String senha, LocalDateTime instante) {
            this.login = login;
            this.senha = new BCryptPasswordEncoder().encode(senha);
            this.instante = instante;
        }

        public String getLogin() {
            return login;
        }

        public String getSenha() {
            return senha;
        }

        public LocalDateTime getInstante() {
            return instante;
        }
}
