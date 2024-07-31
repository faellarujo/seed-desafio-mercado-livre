package com.pt.mercadolivre.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Compra {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;


    private String gateway;


    @ManyToMany
    @JoinTable(name = "compra_produto",
            joinColumns = @JoinColumn(name = "compra_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id"))
    private Set<Produto> produto;


    @OneToOne(cascade = CascadeType.ALL)
    private User comprador;


    private StatusDaCompra statusDaCompra;

    public Compra(String gateway, Set<Produto> produto, User comprador, StatusDaCompra statusDaCompra) {
        this.gateway = gateway;
        this.produto = produto;
        this.comprador = comprador;
        this.statusDaCompra = statusDaCompra;
    }

    public Long getId() {
        return id;
    }

    public String getGateway() {
        return gateway;
    }

    public Set<Produto> getProduto() {
        return produto;
    }

    public User getComprador() {
        return comprador;
    }

    public StatusDaCompra getStatusDaCompra() {
        return statusDaCompra;
    }
}
