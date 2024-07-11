package com.pt.mercadolivre.service;

import com.pt.mercadolivre.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @PersistenceContext
    private EntityManager manager;

    public User findByusername(String username){
        return manager.createQuery("select u from User u where u.username = :username", User.class)
                .setParameter("username", username)
                .getSingleResult();
    }

    public boolean ownerCadastro(User user){
        return user.getUsername().equals(user.getUsername());
    }
}
