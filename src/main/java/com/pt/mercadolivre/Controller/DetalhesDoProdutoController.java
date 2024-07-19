package com.pt.mercadolivre.Controller;


import com.pt.mercadolivre.views.DetalesDoProdutoView;
import com.pt.mercadolivre.model.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DetalhesDoProdutoController {

    @PersistenceContext
    private EntityManager manager;

    @GetMapping(value = "/produto/{id}/detalhes")
    public ResponseEntity<DetalesDoProdutoView> detalhesDoProduto(@PathVariable Long id){
        final Produto produto = manager.find(Produto.class, id);
        DetalesDoProdutoView detalhesDoProdutoView = new DetalesDoProdutoView(produto);
        return ResponseEntity.ok(detalhesDoProdutoView);
    }
}
