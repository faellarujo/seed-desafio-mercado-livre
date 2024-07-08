package com.pt.mercadolivre.Controller;


import com.pt.mercadolivre.Request.ProdutoRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoController {


    @PostMapping("/produto")
    public String cadastrarProduto(@RequestBody @Valid ProdutoRequest request){
        return request.toString();
    }
}
