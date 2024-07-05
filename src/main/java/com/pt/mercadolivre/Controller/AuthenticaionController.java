package com.pt.mercadolivre.Controller;


import com.pt.mercadolivre.service.AuthenticationService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Esse cara é responsavel por chamar o serviço de autenticaçao AuthenticationService
 */

@RestController
public class AuthenticaionController {

    private AuthenticationService autehnticationService;

    public AuthenticaionController(AuthenticationService serviceController) {
        this.autehnticationService = serviceController;
    }

    /**
     * É passado o Authentication como parametro o Spring tem seus proprios mecanismos de injeção de dependencia
     * @param authentication
     * @return
     */


    @PostMapping("/authenticate")
    public String authenticate(Authentication authentication) {
        return autehnticationService.authenticate(authentication);
    }



}
