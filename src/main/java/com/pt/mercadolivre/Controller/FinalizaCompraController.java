package com.pt.mercadolivre.Controller;


import com.pt.mercadolivre.Request.PagueSeguroRequest;
import com.pt.mercadolivre.model.Compra;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FinalizaCompraController {

    @PersistenceContext
    EntityManager manager;



    @PostMapping("/compra/retorno-pagueseguro/{id}/")
    public String statusCompra(@PathVariable Long id, PagueSeguroRequest request, Authentication authentication) {
        final Compra compra = manager.find(Compra.class, id);


        // preciso add uma tentativa de pagamento

        compra.tentativaDePagamento(request);




        return request.toString();
    }
}
