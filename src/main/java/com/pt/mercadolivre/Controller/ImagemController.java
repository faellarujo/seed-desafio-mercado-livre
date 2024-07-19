package com.pt.mercadolivre.Controller;


import com.pt.mercadolivre.Request.ImagemRequest;
import com.pt.mercadolivre.exception.UserNotPermission;
import com.pt.mercadolivre.model.ImagemProduto;
import com.pt.mercadolivre.model.Produto;
import com.pt.mercadolivre.repository.ProdutoRepository;
import com.pt.mercadolivre.repository.UsuarioRepository;
import com.pt.mercadolivre.service.ProdutoService;
import com.pt.mercadolivre.service.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImagemController {

    @PersistenceContext
    private EntityManager manager;


    @Autowired
    private UserService userService;

    @Autowired
    private ProdutoService produtoService;


    @Autowired
    private ProdutoRepository produtoRepositury;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/imagem")
    @Transactional
    public ResponseEntity<ImagemProduto> cadastrarImagem(@RequestBody @Valid ImagemRequest request, Authentication authentication){
        final Produto userOwnerProduto = produtoRepositury.findById(request.getIdProduto()).get();
        manager.persist(request.toModel(manager));
        return ResponseEntity.ok().build();
    }
}
