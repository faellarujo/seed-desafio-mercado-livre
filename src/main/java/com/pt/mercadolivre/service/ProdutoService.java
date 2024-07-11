package com.pt.mercadolivre.service;


import com.pt.mercadolivre.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @PersistenceContext
    private EntityManager manager;

    public User findByusername(String username){
        return manager.createQuery("select u from User u where u.username = :username", User.class)
                .setParameter("username", username)
                .getSingleResult();
    }

    public void findByid(Long idProduto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
