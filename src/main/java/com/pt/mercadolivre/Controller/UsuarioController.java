package com.pt.mercadolivre.Controller;

import com.pt.mercadolivre.Request.UsuarioRequest;
import com.pt.mercadolivre.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {


    @Autowired
    private UserService userService;

    @PostMapping("/usuario")
    public UsuarioRequest cadastrarUsuario(@RequestBody @Valid UsuarioRequest request){
        request.setSenha(userService.encodePassword(request.getSenha()));
        return request;
    }
}