package com.pt.mercadolivre.Controller;


import com.pt.mercadolivre.Request.CompraRequest;
import com.pt.mercadolivre.Request.PagueSeguroRequest;
import com.pt.mercadolivre.exception.ProdutoNotExistException;
import com.pt.mercadolivre.model.Compra;
import com.pt.mercadolivre.model.Produto;
import com.pt.mercadolivre.model.StatusDaCompra;
import com.pt.mercadolivre.model.User;
import com.pt.mercadolivre.repository.CompraRepossitory;
import com.pt.mercadolivre.repository.ProdutoRepository;
import com.pt.mercadolivre.repository.UsuarioRepository;
import com.pt.mercadolivre.service.ProdutoService;
import com.pt.mercadolivre.util.EnviaEmail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.header.Header;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
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

    @PersistenceContext
    EntityManager entityManager;


    @Autowired
    private CompraRepossitory compraRepossitory;


    @PostMapping("/produto/compra/")
    @Transactional
    public ResponseEntity<String> pagamento(@RequestBody @Valid CompraRequest request, Authentication authentication) throws URISyntaxException {
        // recupera o produto pelo id
        final Optional<Produto> produto = produtoRepository.findById(request.getIdProduto());
        Optional.ofNullable(produto).orElseThrow(() -> new ProdutoNotExistException("Produto não encontrado"));

        // verifica a quantidade em estoque e abate se possivel
        produto.get().abateEstoque(request.getQuantidade());

        // Recupera o comprador
        final User comprador = usuarioRepository.findByUsername(authentication.getName()).get();
        // Envia email para o dono do produto
        new EnviaEmail().enviaEmail("dona@gmail.com", "Pedido de compra", "O usuário " + comprador.getUsername() + " Tem interesse no produto " + produto.get().getNome());

        // Iniciado o status da compra
        System.out.println("Status da compra: " + StatusDaCompra.INICIADA.toString());

        // Cria a entidade Compra e persiste no banco de dados
        Compra compra = request.toModel(entityManager, produto.get(), comprador);
        entityManager.persist(compra);

        // Verifica o tipo de pagamento escolhido e retorna a URL de redirecionamento
        URI redirectUrl;
        if (request.getGateway().equals(request.getGateway().PAYPAL)) {
            String urlTemplate = "https://paypal.com/" + compra.getId() + "?redirectUrl=" + "urlRetornoAppPosPagamento";
            redirectUrl = URI.create(urlTemplate);
        } else {
            String urlTemplate = "https://pagseguro.com/" + compra.getId() + "/" + comprador.getId() + "/";
            redirectUrl = URI.create(urlTemplate);
        }
        return new ResponseEntity<>(redirectUrl.toString(), HttpStatus.FOUND);
    }

}
