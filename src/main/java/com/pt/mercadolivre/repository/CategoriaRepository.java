package com.pt.mercadolivre.repository;

import com.pt.mercadolivre.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.nio.file.OpenOption;
import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    public Optional<Categoria> findByNome(String nome);
}
