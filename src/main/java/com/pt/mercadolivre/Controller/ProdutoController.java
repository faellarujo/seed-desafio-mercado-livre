package com.pt.mercadolivre.Controller;


import com.pt.mercadolivre.Request.ProdutoRequest;
import com.pt.mercadolivre.model.Produto;
import com.pt.mercadolivre.model.User;
import com.pt.mercadolivre.service.AuthenticationService;
import com.pt.mercadolivre.service.UserService;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ProdutoController {


    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private EntityManager manager;

    @Autowired
    private UserService userService;


    @PostMapping("/produto")
    @Transactional
    public String cadastrarProduto(@RequestBody @Valid ProdutoRequest request, Authentication authentication){
        final String authenticate = authenticationService.authenticate(authentication);
        final Produto produto = request.toModel(manager);
        final User byusername = userService.findByusername(authentication.getName());
        produto.setUsuario(byusername);
        manager.persist(produto);
        return request.toString();
    }
}
