package com.pt.mercadolivre.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private StautsRetornoPagueSeguro status;
    private String transacaoId;
    private LocalDateTime instante = LocalDateTime.now();

    @OneToOne(mappedBy = "transacao", cascade = CascadeType.ALL)
    private Compra compra;

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Transacao(StautsRetornoPagueSeguro status, String transacaoId, LocalDateTime instante, Compra compra) {
        this.status = status;
        this.transacaoId = transacaoId;
        this.instante = instante;
        this.compra = compra;
    }

    public Long getId() {
        return id;
    }

    public StautsRetornoPagueSeguro getStatus() {
        return status;
    }

    public String getCompraId() {
        return transacaoId;
    }

    public LocalDateTime getInstante() {
        return instante;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStatus(StautsRetornoPagueSeguro status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "id=" + id +
                ", status=" + status +
                ", transacaoId='" + transacaoId + '\'' +
                ", instante=" + instante +
                '}';
    }
}
