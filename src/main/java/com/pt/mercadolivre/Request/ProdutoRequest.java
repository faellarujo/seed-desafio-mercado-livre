package com.pt.mercadolivre.Request;

import com.pt.mercadolivre.model.*;
import jakarta.persistence.EntityManager;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;
import java.util.Optional;

public class ProdutoRequest {

    @NotBlank
    private String nome;

    @NotNull
    @Min(1)
    private Double valor;

    @NotNull
    @Min(1)
    private Integer quantidade;

    @NotNull
    private Long idCaracteristica;

    @NotBlank
    @Size(max = 1000)
    private String descricao;

    @NotNull
    private Long idCategoria;

    private Long idImagem;


    private Long idUsuario;

    @NotNull
    @PastOrPresent
    LocalDateTime instante = LocalDateTime.now();

    public ProdutoRequest() {
    }

    public ProdutoRequest(@NotBlank String nome, @NotNull @Min(1) Double valor, @NotNull @Min(1) Integer quantidade, @NotNull Long idCaracteristica, @NotBlank @Size(max = 1000) String descricao, @NotNull Long idCategoria, @NotNull @PastOrPresent LocalDateTime instante, Long idImagem, Long idUsuario) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.idCaracteristica = idCaracteristica;
        this.descricao = descricao;
        this.idCategoria = idCategoria;
        this.instante = instante;
        this.idImagem = idImagem;
        this.idUsuario = idUsuario;
    }

    public @NotBlank String getNome() {
        return nome;
    }

    public void setNome(@NotBlank String nome) {
        this.nome = nome;
    }

    public @NotNull @Min(1) Double getValor() {
        return valor;
    }

    public void setValor(@NotNull @Min(1) Double valor) {
        this.valor = valor;
    }

    public @NotNull Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(@NotNull Integer quantidade) {
        this.quantidade = quantidade;
    }

    public @NotNull Long getIdCaracteristica() {
        return idCaracteristica;
    }

    public void setIdCaracteristica(@NotNull Long idCaracteristica) {
        this.idCaracteristica = idCaracteristica;
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

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }


    @Override
    public String toString() {
        return "ProdutoRequest{" +
                "nome='" + nome + '\'' +
                ", valor=" + valor +
                ", quantidade=" + quantidade +
                ", caracteristica=" + idCaracteristica +
                ", descricao='" + descricao + '\'' +
                ", idCategoria=" + idCategoria +
                ", instante=" + instante +
                   ", idImagem=" + idImagem +
                     ", idUsuario=" + idUsuario +
                '}';
    }

    public Produto toModel(EntityManager manager) {
        Caracteristica caracteristica = manager.find(Caracteristica.class, idCaracteristica);
        Categoria categoria = manager.find(Categoria.class, idCategoria);
        Optional<ImagemProduto> imagem = Optional.ofNullable(idImagem).map(id -> manager.find(ImagemProduto.class, id));
        Optional<User> usuario = Optional.ofNullable(idUsuario).map(id -> manager.find(User.class, id));

        if (caracteristica == null || categoria == null) {
            throw new IllegalArgumentException("Caracteristica, Categoria, or ImagemProduto not found");
        }
        return new Produto(nome, valor, quantidade, caracteristica, descricao, categoria, instante, imagem.orElse(null), usuario.orElse(null));
    }
}
