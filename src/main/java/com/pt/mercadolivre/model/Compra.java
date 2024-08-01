package com.pt.mercadolivre.model;

import jakarta.persistence.*;
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
            joinColumns = @JoinColumn(name = "compra_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private Set<Produto> produtos;

    @ManyToOne(cascade = CascadeType.ALL)
    private User comprador;

    @Enumerated(EnumType.STRING)
    private StatusDaCompra statusDaCompra;

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

    public Compra() {
    }

    public Compra(String gateway, Set<Produto> produtos, User comprador, StatusDaCompra statusDaCompra) {
        this.gateway = gateway;
        this.produtos = produtos;
        this.comprador = comprador;
        this.statusDaCompra = statusDaCompra;
    }
}