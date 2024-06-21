package com.pt.mercadolivre.Controller;

import com.pt.mercadolivre.Request.CategoriaRquest;
import com.pt.mercadolivre.Request.SubCategoriaRequest;
import com.pt.mercadolivre.model.Categoria;
import com.pt.mercadolivre.model.SubCategoria;
import com.pt.mercadolivre.service.CategoriaService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubCategoriaController {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private CategoriaService categoriaService;


    @PostMapping("/subcategoria")
    @Transactional
    public String cadastrarSubCategoria(@RequestBody @Valid SubCategoriaRequest request){
        final Categoria categoria = categoriaService.buscaCategoria(request.getCategoria().getNome()).get();
        if (manager.contains(categoria)) {
            manager.persist(request.toModel(categoria));
        }
        return request.toString();
    }
}
