package com.pt.mercadolivre.Controller;

import com.pt.mercadolivre.Request.UsuarioRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    @PostMapping("/usuario")
    public UsuarioRequest cadastrarUsuario(@RequestBody @Valid UsuarioRequest request){
        return request;
    }
}