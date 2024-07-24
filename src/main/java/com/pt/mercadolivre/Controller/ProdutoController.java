package com.pt.mercadolivre.Controller;

import com.pt.mercadolivre.Request.NovasImagensRequest;
import com.pt.mercadolivre.Request.ProdutoRequest;
import com.pt.mercadolivre.model.ImagemProduto;
import com.pt.mercadolivre.model.Produto;
import com.pt.mercadolivre.model.User;
import com.pt.mercadolivre.service.AuthenticationService;
import com.pt.mercadolivre.service.UserService;
import com.pt.mercadolivre.util.UploaderFake;
import com.pt.mercadolivre.validadores.ProibeCaracteristicasComNomesIguaisValidator;
import com.pt.mercadolivre.views.DetalesDoProdutoView;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@RestController
public class ProdutoController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private EntityManager manager;

    @Autowired
    private UserService userService;

    @Autowired
    private UploaderFake uploaderFake;



    @InitBinder(value = "produtoRequest")
    public void init(WebDataBinder binder){
        binder.addValidators(new ProibeCaracteristicasComNomesIguaisValidator());
    }

    @PostMapping("/produto")
    @Transactional
    public String cadastrarProduto(@RequestBody @Valid ProdutoRequest request, Authentication authentication){
        User user = userService.findByusername(authentication.getName());
        Produto produto = request.toModel(manager, user);
        manager.persist(produto);
        return request.toString();
    }


    @PostMapping("/produto/{id}/imagens")
    @Transactional
    public void adicionaImagens(@PathVariable("id") Long id, @Valid NovasImagensRequest novasImagensRequest){

        /**
         * 1 - Enviar imagens para o servidor
         * 2 - Pegar o link de todas as imagens
         * 3 - Associar esses links com o produto
         * 4 - Preciso carregar o produto
         * 5 - Depois que associar eu preciso atualizar a nova versao do produto
         *
         */

         Set<String> links = UploaderFake.envia(novasImagensRequest.getImagens());
         links.forEach(link -> System.out.println("Link: " + link));

        final Produto produto = manager.find(Produto.class, id);
        links.stream().map(link -> new ImagemProduto(link, produto)).forEach(manager::persist);
    }


    @GetMapping(value = "/produtos")
    public ResponseEntity<List<DetalesDoProdutoView>> listarProdutos(){
        //final User byusername = userService.findByusername(authentication.getName());
        List<Produto> listaDeProdutos = manager.createQuery("select p from Produto p", Produto.class).getResultList();
        List<DetalesDoProdutoView> listaDeDetalhesDoProduto = listaDeProdutos.stream()
                .map(produto -> new DetalesDoProdutoView(produto, manager))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(listaDeDetalhesDoProduto);
    }


    @GetMapping(value = "/produto/{id}/detalhes")
    public ResponseEntity<DetalesDoProdutoView> detalhesDoProduto(@PathVariable Long id){
        final Produto produto = manager.find(Produto.class, id);
        DetalesDoProdutoView detalhesDoProdutoView = new DetalesDoProdutoView(produto, manager);
        return ResponseEntity.ok(detalhesDoProdutoView);
    }

}
