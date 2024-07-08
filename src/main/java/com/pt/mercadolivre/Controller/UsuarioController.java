package com.pt.mercadolivre.Controller;

import com.pt.mercadolivre.Request.UsuarioRequest;
import com.pt.mercadolivre.repository.UsuarioRepository;
import com.pt.mercadolivre.service.AuthenticationService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/usuario")
    @Transactional
    public String cadastrarUsuario(@RequestBody @Valid UsuarioRequest request){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        manager.persist(request.toModel());
        final String authenticate = authenticationService.authenticate(authentication);
        return authenticate;
    }
}