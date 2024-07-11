package com.pt.mercadolivre.repository;

import com.pt.mercadolivre.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepositury extends JpaRepository<Produto, Long> {

    public Optional<Produto> findById (Long id);
}
