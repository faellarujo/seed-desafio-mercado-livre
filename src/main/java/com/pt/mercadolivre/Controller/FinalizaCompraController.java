package com.pt.mercadolivre.Controller;


import com.pt.mercadolivre.Request.PagueSeguroRequest;
import com.pt.mercadolivre.Request.SetorNotaFiscalRequest;
import com.pt.mercadolivre.model.Compra;
import com.pt.mercadolivre.model.StatusDaCompra;
import com.pt.mercadolivre.model.StautsRetornoPagueSeguro;
import com.pt.mercadolivre.model.Transacao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FinalizaCompraController {

    @PersistenceContext
    EntityManager manager;



    @PostMapping("/compra/retorno-pagueseguro/{id}/")
    @Transactional
    public String statusCompra(@PathVariable Long id, PagueSeguroRequest request, Authentication authentication) {
        final Compra compra = manager.find(Compra.class, id);
        // preciso add uma tentativa de pagamento
        compra.tentativaDePagamento(request, manager);
        comunicaAoSetoDeNotasFiscais(compra);
        return request.toString();
    }

    @PostMapping("/compra/setorFiscal/")
    @Transactional
    public String comunicasoSetorFiscal(@PathVariable Long id, SetorNotaFiscalRequest request) {
        final Compra compra = manager.find(Compra.class, id);
        // preciso add uma tentativa de pagamento
        request.comunicaAoSetoDeNotasFiscais(compra);

        return request.toString();
    }




}
