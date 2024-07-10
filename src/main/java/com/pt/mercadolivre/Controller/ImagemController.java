package com.pt.mercadolivre.Controller;


import com.pt.mercadolivre.Request.ImagemRequest;
import com.pt.mercadolivre.model.ImagemProduto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImagemController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping("/imagem")
    @Transactional
    public ResponseEntity<ImagemProduto> cadastrarImagem(@RequestBody @Valid ImagemRequest request, Authentication authentication){
        manager.persist(request.toModel(manager));
        return ResponseEntity.ok().build();
    }
}
