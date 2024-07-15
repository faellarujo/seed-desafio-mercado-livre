package com.pt.mercadolivre.Controller;

import com.pt.mercadolivre.Request.OpiniaoRequest;
import com.pt.mercadolivre.exception.ProdutoNotExistException;
import com.pt.mercadolivre.exception.UserNotExistException;
import com.pt.mercadolivre.model.Opiniao;
import com.pt.mercadolivre.model.Produto;
import com.pt.mercadolivre.model.User;
import com.pt.mercadolivre.repository.UsuarioRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpiniaoController {


    @PersistenceContext
    private EntityManager manager;


    @Autowired
    private UsuarioRepository usuarioRepository;



    @PostMapping(value = "/produto/{id}/opiniao", consumes = "application/json")
    @Transactional
    public String cadastrarOpiniao(@RequestBody @Valid OpiniaoRequest opiniaoRequest, @PathVariable Long id, Authentication authentication){
        try {
            final Produto produto = manager.find(Produto.class, id);
            final User usuarioUtenticado = usuarioRepository.findByUsername(authentication.getName()).get();
            final Opiniao model = opiniaoRequest.toModel(produto, usuarioUtenticado);
            manager.persist(model);
            return opiniaoRequest.toString();
        } catch (UserNotExistException e) {
            throw new UserNotExistException("Produto não encontrado");
        } catch (ProdutoNotExistException e) {
            throw new ProdutoNotExistException("Usuário não encontrado");
        }


    }
}
