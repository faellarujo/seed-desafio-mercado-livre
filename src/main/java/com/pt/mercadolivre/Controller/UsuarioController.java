package com.pt.mercadolivre.Controller;

import com.pt.mercadolivre.Request.UsuarioRequest;
import com.pt.mercadolivre.repository.UsuarioRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {




    @PersistenceContext
    private EntityManager manager; //2

    @Autowired
    private UsuarioRepository usuarioRepository; //3


    @PostMapping("/usuario")
    @Transactional
    public UsuarioRequest cadastrarUsuario(@RequestBody @Valid UsuarioRequest request){
        manager.persist(request.toModel());
        return request;
    }
}