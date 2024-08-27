package com.pt.mercadolivre.Controller;


import com.pt.mercadolivre.Request.PagueSeguroRequest;
import com.pt.mercadolivre.Request.SetorNotaFiscalRequest;
import com.pt.mercadolivre.model.Compra;
import com.pt.mercadolivre.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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

    private String comunicaAoSetoDeNotasFiscais(Compra compra) {
        return "comunicado ao setor fiscal";
    }

    @PostMapping("/compra/setorFiscal/{idUsuario}/{idCompra}")
    @Transactional
    public String comunicasoSetorFiscal(@PathVariable Long idUsuario, @PathVariable Long idCompra, SetorNotaFiscalRequest request) {
        final Compra compra = manager.find(Compra.class, idCompra);
        // preciso add uma tentativa de pagamento
        final User user = manager.find(User.class, idUsuario);
        request.comunicaAoSetoDeNotasFiscais(idCompra, idUsuario);
        return request.toString();
    }

}
