package com.pt.mercadolivre.model;

import com.pt.mercadolivre.Request.PagueSeguroRequest;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String gateway;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "compra_produto",
            joinColumns = @JoinColumn(referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private Set<Produto> produtos;

    @ManyToOne(cascade = CascadeType.ALL)
    private User comprador;

    @Enumerated(EnumType.STRING)
    private StatusDaCompra statusDaCompra;

    public void setStatusDaCompra(StatusDaCompra statusDaCompra) {
        this.statusDaCompra = statusDaCompra;
    }

    @OneToOne
    @JoinColumn(name = "transacao_id")
    private Transacao transacao;


    public Long getId() {
        return id;
    }

    public String getGateway() {
        return gateway;
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public User getComprador() {
        return comprador;
    }

    public StatusDaCompra getStatusDaCompra() {
        return statusDaCompra;
    }

    public Transacao getTransacao() {
        return transacao;
    }

    public void setTransacao(Transacao transacao) {
        this.transacao = transacao;
    }

    public Compra() {
    }

    public Compra(String gateway, Set<Produto> produtos, User comprador, StatusDaCompra statusDaCompra) {
        this.gateway = gateway;
        this.produtos = produtos;
        this.comprador = comprador;
        this.statusDaCompra = statusDaCompra;
    }


    public void tentativaDePagamento(PagueSeguroRequest request, EntityManager entityManager) {
        Transacao transacao = new Transacao(request.getStatus(), request.getIdTransacao(), LocalDateTime.now(), this);
        if (request.getStatus().equals(StautsRetornoPagueSeguro.SUCESSO)) {
            entityManager.persist(transacao);
            this.setStatusDaCompra(StatusDaCompra.SUCESSO);
        } else {
            this.setStatusDaCompra(StatusDaCompra.ERRO);
        }
        this.transacao = transacao;
    }
}