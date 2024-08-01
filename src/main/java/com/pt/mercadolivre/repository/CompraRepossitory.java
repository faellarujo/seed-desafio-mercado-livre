package com.pt.mercadolivre.repository;

import com.pt.mercadolivre.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompraRepossitory extends JpaRepository<Compra, Long> {

    public Optional<Compra> findById(Long id);
}
