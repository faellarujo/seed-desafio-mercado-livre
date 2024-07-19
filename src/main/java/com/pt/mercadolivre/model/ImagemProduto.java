package com.pt.mercadolivre.model;


import jakarta.persistence.*;

@Entity(name = "imagem_produto")
public class ImagemProduto {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;


    @Column(name = "link_imagem")
    private String linkImagem;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    public ImagemProduto() {
    }

    public ImagemProduto(String linkImagem, Produto produto) {
        this.linkImagem = linkImagem;
        this.produto = produto;
    }

    public String getLinkImagem() {
        return linkImagem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLinkImagem(String linkImagem) {
        this.linkImagem = linkImagem;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        return "ImagemProduto{" +
                "linkImagem='" + linkImagem + '\'' +
                '}';
    }

}
