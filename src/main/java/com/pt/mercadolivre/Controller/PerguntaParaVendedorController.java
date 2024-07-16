package com.pt.mercadolivre.Controller;


import com.pt.mercadolivre.Request.PerquntaRequest;
import com.pt.mercadolivre.exception.ProdutoNotExistException;
import com.pt.mercadolivre.model.Pergunta;
import com.pt.mercadolivre.model.Produto;
import com.pt.mercadolivre.model.User;
import com.pt.mercadolivre.model.Vendedor;
import com.pt.mercadolivre.repository.UsuarioRepository;
import com.pt.mercadolivre.util.EnviaEmail;
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

import java.util.Optional;

@RestController
public class PerguntaParaVendedorController {


    @PersistenceContext
    private EntityManager manager;


    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/produto/{id}/pergunta")
    @Transactional
    public String perguntaParaVendedor(@RequestBody @Valid PerquntaRequest request, @PathVariable Long id, Authentication authentication) throws ProdutoNotExistException {
        Produto produto = manager.find(Produto.class, id);
        Optional.ofNullable(produto).orElseThrow(() -> new ProdutoNotExistException("Produto não encontrado"));
        Vendedor vendedor = manager.find(Vendedor.class, request.getIdVendedor());
        Optional.ofNullable(vendedor).orElseThrow(() -> new ProdutoNotExistException("Vendedor não encontrado"));
        User user = usuarioRepository.findByUsername(authentication.getName()).get();
        final Pergunta model = request.toModel(produto, vendedor, user);
        manager.persist(model);
        EnviaEmail.enviaEmail(vendedor.getEmail(), "Nova pergunta sobre o produto: " + produto.getNome(), model.getDescricao());
        return model.toString();
    }
}

