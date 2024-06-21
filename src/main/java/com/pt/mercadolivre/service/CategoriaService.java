package com.pt.mercadolivre.service;

import com.pt.mercadolivre.exception.CategoriaExisteException;
import com.pt.mercadolivre.model.Categoria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CategoriaService {

    @PersistenceContext
    private EntityManager manager;

    public Optional<Categoria> buscaCategoria(String nome){
        try {
            final Categoria categoria = manager.createQuery("select c from Categoria c where c.nome = :nome", Categoria.class)
                    .setParameter("nome", nome)
                    .getSingleResult();
            return Optional.ofNullable(categoria);
        } catch(NoResultException e){
            throw new CategoriaExisteException("Categoria não encontrada: " + nome);
        }
}
}