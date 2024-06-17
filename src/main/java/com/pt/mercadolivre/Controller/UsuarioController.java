package com.pt.mercadolivre.Controller;

import com.pt.mercadolivre.Request.UsuarioRequest;
import com.pt.mercadolivre.service.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {


    @Autowired
    private UserService userService; //1

    @PersistenceContext
    private EntityManager manager; //2



    @PostMapping("/usuario")
    @Transactional
    public UsuarioRequest cadastrarUsuario(@RequestBody @Valid UsuarioRequest request){
        request.setSenha(userService.encodePassword(request.getSenha()));
        manager.persist(request.toModel());
        return request;
    }
}