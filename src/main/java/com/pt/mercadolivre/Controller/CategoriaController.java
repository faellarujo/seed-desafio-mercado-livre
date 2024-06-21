package com.pt.mercadolivre.Controller;


import com.pt.mercadolivre.Request.CategoriaRquest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriaController {



    @PersistenceContext
    private EntityManager manager;


    @PostMapping("/categoria")
    @Transactional
    public String cadastrarCategoria(@RequestBody @Valid CategoriaRquest request){
        manager.persist(request.toModel());
        return request.toString();
    }
}
