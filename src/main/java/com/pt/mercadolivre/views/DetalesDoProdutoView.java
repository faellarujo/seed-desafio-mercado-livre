package com.pt.mercadolivre.views;

import com.pt.mercadolivre.model.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DetalesDoProdutoView {

    @PersistenceContext
    private final EntityManager manager;

    private String descricao;
    private String nome;
    private BigDecimal valor;
    private String categoria;
    private Long idUser;
    private String userName;
    private List<String> imagens = new ArrayList<>();
    private List<CaracteristicasDetalhesView> caracteristicas = new ArrayList<>();
    private List<OpiniaoDoProdutoDetalheView> opinioes = new ArrayList<>();
    private double mediaNota;
    private int numeroTotaldeNotas;
    private List<PerguntasAoVendedorView> perguntas = new ArrayList<>();

    public DetalesDoProdutoView(Produto produto, EntityManager manager) {
        this.manager = manager;
        setProduto(produto);
    }

    public void setProduto(Produto produto) {
        this.descricao = produto.getDescricao();
        this.nome = produto.getNome();
        this.valor = produto.getValor();
        this.categoria = produto.getCategoria().getNome();
        this.idUser = Optional.ofNullable(produto.getUser()).map(User::getId).orElse(0L);
        this.userName = Optional.ofNullable(produto.getUser()).map(User::getUsername).orElse("");
        this.imagens = produto.getLinkImagem().stream()
                .map(ImagemProduto::getLinkImagem)
                .collect(Collectors.toList());
        this.caracteristicas = produto.getCaracteristica().stream()
                .map(CaracteristicasDetalhesView::new)
                .collect(Collectors.toList());
        this.opinioes =  opinioesDoProduto(produto);
        this.perguntas = produto.getPerguntas().stream()
                .map(PerguntasAoVendedorView::new)
                .collect(Collectors.toList());
        this.mediaNota = calcularMedia(opinioes);
        this.numeroTotaldeNotas = opinioes.size();

    }

    private List<OpiniaoDoProdutoDetalheView> opinioesDoProduto(Produto produto) {
        final Long id = produto.getId();
        Query query = manager.createQuery("select o from Opiniao o where o.produto.id = :id");
        query.setParameter("id", id);
        List<Opiniao> opinioes = query.getResultList();
        return opinioes.stream()
                .map(OpiniaoDoProdutoDetalheView::new)
                .collect(Collectors.toList());
    }

    private double calcularMedia(List<OpiniaoDoProdutoDetalheView> opinioes) {
        return opinioes.stream()
                .mapToInt(OpiniaoDoProdutoDetalheView::getNota)
                .average()
                .orElse(0.0);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getImagens() {
        return imagens;
    }

    public void setImagens(List<String> imagens) {
        this.imagens = imagens;
    }

    public List<CaracteristicasDetalhesView> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<CaracteristicasDetalhesView> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public List<OpiniaoDoProdutoDetalheView> getOpinioes() {
        return opinioes;
    }

    public void setOpinioes(List<OpiniaoDoProdutoDetalheView> opinioes) {
        this.opinioes = opinioes;
    }
    public double getMediaNota() {
        return mediaNota;
    }

    public int getNumeroTotaldeNotas() {
        return numeroTotaldeNotas;
    }

    public void setPerguntas(List<PerguntasAoVendedorView> perguntas) {
        this.perguntas = perguntas;
    }

    public List<PerguntasAoVendedorView> getPerguntas() {
        return perguntas;
    }
}
