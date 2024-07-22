package com.pt.mercadolivre.Controller;

import com.pt.mercadolivre.Request.ProdutoRequest;
import com.pt.mercadolivre.model.Produto;
import com.pt.mercadolivre.service.AuthenticationService;
import com.pt.mercadolivre.service.UserService;
import com.pt.mercadolivre.validadores.ProibeCaracteristicasComNomesIguaisValidator;
import com.pt.mercadolivre.views.DetalesDoProdutoView;
import jakarta.persistence.EntityManager;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
public class ProdutoController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private EntityManager manager;

    @Autowired
    private UserService userService;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(new ProibeCaracteristicasComNomesIguaisValidator());
    }

    @PostMapping("/produto")
    public String cadastrarProduto(@RequestBody @Valid ProdutoRequest request){
        return request.toString();
    }

//    @PostMapping("/produto")
//    @Transactional
//    public ResponseEntity<DetalesDoProdutoView> cadastrarProduto(@RequestBody @Valid ProdutoRequest request, Authentication authentication){
//        final User byusername = userService.findByusername(authentication.getName());
//        final Produto produto = request.toModel(manager, byusername);
//        DetalesDoProdutoView detalesDoProdutoView = new DetalesDoProdutoView(produto);
//        detalesDoProdutoView.setProduto(produto);
//        manager.persist(produto);
//        return ResponseEntity.status(HttpStatus.CREATED).body(detalesDoProdutoView);
//    }

    @GetMapping(value = "/produtos")
    public ResponseEntity<List<DetalesDoProdutoView>> listarProdutos(){
        //final User byusername = userService.findByusername(authentication.getName());
        List<Produto> listaDeProdutos = manager.createQuery("select p from Produto p", Produto.class).getResultList();
        List<DetalesDoProdutoView> listaDeDetalhesDoProduto = listaDeProdutos.stream()
                .map(DetalesDoProdutoView::new)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(listaDeDetalhesDoProduto);
    }

}
