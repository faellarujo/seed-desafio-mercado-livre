package com.pt.mercadolivre.Controller;


import com.pt.mercadolivre.Request.CompraRequest;
import com.pt.mercadolivre.exception.ProdutoNotExistException;
import com.pt.mercadolivre.exception.QuantidadeInsulficienteException;
import com.pt.mercadolivre.model.Produto;
import com.pt.mercadolivre.model.User;
import com.pt.mercadolivre.repository.ProdutoRepository;
import com.pt.mercadolivre.repository.UsuarioRepository;
import com.pt.mercadolivre.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CompraController {


    /***
     * A pessoa pode escolher a quantidade de itens daquele produto que ela quer comprar
     * O estoque do produto é abatido 
     * Um email é enviado para a pessoa que é dona(o) do produto informando que um usuário realmente disse que queria comprar seu produto.
     * Uma compra é gerada informando o status INICIADA e com as seguintes informações:
     * gateway escolhido para pagamento
     * produto escolhido
     * quantidade
     * comprador(a)
     * Suponha que o cliente pode escolher entre pagar com o Paypal ou Pagseguro.
     */


    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProdutoRepository produtoRepository;


    @Autowired
    private ProdutoService produtoService;


    @PostMapping("/produto/{id}/compra")
    private String pagamento(@RequestBody  @Valid CompraRequest request, @PathVariable Long id, Authentication authentication){

        // recupera o produto pelo id
        final Optional<Produto> produto = produtoRepository.findById(id);
        Optional.ofNullable(produto).orElseThrow(() -> new ProdutoNotExistException("Produto não encontrado"));

        //verifica a quantidade em estoque

        if (request.getQuantidade() > produto.get().getQuantidade()){
            throw new QuantidadeInsulficienteException("Quantidade insuficiente em estoque");
        }
        produtoService.abateEstoque(produto.get().getId(), request.getQuantidade());

        // Recupera o comprador
        final User comprador = usuarioRepository.findByUsername(authentication.getName()).get();
        return request.toString();
    }

}
