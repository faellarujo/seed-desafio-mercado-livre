package com.pt.mercadolivre.Controller;


import com.pt.mercadolivre.Request.ImagemRequest;
import com.pt.mercadolivre.exception.UserNotPermission;
import com.pt.mercadolivre.model.ImagemProduto;
import com.pt.mercadolivre.model.Produto;
import com.pt.mercadolivre.model.User;
import com.pt.mercadolivre.repository.ProdutoRepositury;
import com.pt.mercadolivre.repository.UsuarioRepository;
import com.pt.mercadolivre.service.ProdutoService;
import com.pt.mercadolivre.service.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ImagemController {

    @PersistenceContext
    private EntityManager manager;


    @Autowired
    private UserService userService;

    @Autowired
    private ProdutoService produtoService;


    @Autowired
    private ProdutoRepositury produtoRepositury;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/imagem")
    @Transactional
    public ResponseEntity<ImagemProduto> cadastrarImagem(@RequestBody @Valid ImagemRequest request, Authentication authentication){

        // pegar o usuario do produto

        final Produto userOwnerProduto = produtoRepositury.findById(request.getIdProduto()).get();

        // verificar se o usuario logado é o dono do produto

        if(!userOwnerProduto.getUsuario().getUsername().equals("authentication.getName()")){
            throw new UserNotPermission("Usuario não tem permissão para adicionar imagem");
        }
        manager.persist(request.toModel(manager));
        return ResponseEntity.ok().build();
    }
}
