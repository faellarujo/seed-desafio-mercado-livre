package com.pt.mercadolivre.Controller;


import com.pt.mercadolivre.Request.ImagemRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImagemController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping("/imagem")
    @Transactional
    public String cadastrarImagem(@RequestBody @Valid ImagemRequest request){
        manager.persist(request.toModel(manager));
        return request.toString();
    }
}
