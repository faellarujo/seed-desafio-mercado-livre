package com.pt.mercadolivre.Request;

import com.pt.mercadolivre.model.*;
import com.pt.mercadolivre.validadores.ExistId;
import jakarta.persistence.EntityManager;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class ProdutoRequest {

    @NotBlank
    private String nome;

    @NotNull
    @Positive
    private BigDecimal valor;

    @NotNull
    @Positive
    private Integer quantidade;

    @NotNull
    @Size(min = 3)
    @Valid
    private Collection<CaracteristicaRequest> caracteristica = new ArrayList<>();

    @NotBlank
    @Length(max = 1000)
    private String descricao;

    @NotNull
    @ExistId(domainClass = Categoria.class, fieldName = "id")
    private Long idCategoria;

    private Long idImagem;

    @NotNull
    @PastOrPresent
    LocalDateTime instante = LocalDateTime.now();

    public ProdutoRequest() {
    }

    public ProdutoRequest(@NotBlank String nome, @NotNull @Positive BigDecimal valor, @NotNull @Min(1) Integer quantidade, @NotNull @Valid Collection<CaracteristicaRequest> caracteristica , @NotBlank @Length(max = 1000) String descricao, @NotNull Long idCategoria, @NotNull @PastOrPresent LocalDateTime instante, Long idImagem) {
        super();
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.idCategoria = idCategoria;
        this.instante = instante;
        this.idImagem = idImagem;
        this.caracteristica = caracteristica;
        }

    public @NotBlank String getNome() {
        return nome;
    }

    public void setNome(@NotBlank String nome) {
        this.nome = nome;
    }

    public @NotNull @Positive BigDecimal getValor() {
        return valor;
    }

    public void setValor(@NotNull @Positive BigDecimal valor) {
        this.valor = valor;
    }

    public @NotNull Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(@NotNull Integer quantidade) {
        this.quantidade = quantidade;
    }


    public @NotBlank @Size(max = 1000) String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotBlank @Size(max = 1000) String descricao) {
        this.descricao = descricao;
    }

    public @NotNull Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(@NotNull Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public @NotNull @PastOrPresent LocalDateTime getInstante() {
        return instante;
    }

    public void setInstante(@NotNull @PastOrPresent LocalDateTime instante) {
        this.instante = instante;
    }

    public Long getIdImagem() {
        return idImagem;
    }

    public void setIdImagem(Long idImagem) {
        this.idImagem = idImagem;
    }

    public @NotNull @Size(min = 3) @Valid Collection<CaracteristicaRequest> getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(@NotNull @Size(min = 3) @Valid List<CaracteristicaRequest> caracteristica) {
        this.caracteristica = caracteristica;
    }



    @Override
    public String   toString() {
        return "ProdutoRequest{" +
                "caracteristica=" + caracteristica +
                ", nome='" + nome + '\'' +
                ", valor=" + valor +
                ", quantidade=" + quantidade +
                ", descricao='" + descricao + '\'' +
                ", idCategoria=" + idCategoria +
                ", idImagem=" + idImagem +
                ", instante=" + instante +
                '}';
    }

    public boolean temCaracteristicasIguais() {
        HashSet<String> nomesIguais = new HashSet<>();
        for (CaracteristicaRequest caracteristica : caracteristica) {
            if (!nomesIguais.add(caracteristica.getNome())) {
                return true;
            }
        }
        return false;
    }

    public Produto toModel(EntityManager manager, User user) {
        Categoria categoria = manager.find(Categoria.class, idCategoria);
        Produto produto = new Produto(nome, valor, quantidade, new ArrayList<>(), descricao, categoria, instante, user);
        Set<Caracteristica> caracteristicas = this.caracteristica.stream()
                .map(caracteristicaRequest -> caracteristicaRequest.toModel(produto))
                .collect(Collectors.toSet());
        produto.setCaracteristica(caracteristicas);
        return produto;
    }
}
