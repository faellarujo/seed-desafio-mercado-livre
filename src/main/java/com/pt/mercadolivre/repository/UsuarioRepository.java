package com.pt.mercadolivre.repository;

import com.pt.mercadolivre.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
