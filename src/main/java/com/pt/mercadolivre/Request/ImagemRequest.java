package com.pt.mercadolivre.Request;

import com.pt.mercadolivre.exception.ProdutoNotExistException;
import com.pt.mercadolivre.model.ImagemProduto;
import com.pt.mercadolivre.model.Produto;
import jakarta.persistence.EntityManager;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.URL;

import java.util.Optional;

public class ImagemRequest {

        @NotBlank
        @URL
        private String linkImagem;

        @NotNull
        public Long idProduto;

        public ImagemRequest() {
        }

        public ImagemRequest(@NotBlank @URL String linkImagem, @NotNull Long idProduto) {
            this.linkImagem = linkImagem;
            this.idProduto = idProduto;
        }

        public String getLinkImagem() {
            return linkImagem;
        }

        public Long getIdProduto() {
            return idProduto;
        }

        public void setLinkImagem(String linkImagem) {
            this.linkImagem = linkImagem;
        }

        public void setIdProduto(Long idProduto) {
            this.idProduto = idProduto;
        }

        // tosString

        @Override
        public String toString() {
            return "ImagemRequest{" +
                    "linkImagem='" + linkImagem + '\'' +
                    ", idProduto=" + idProduto +
                    '}';
        }

    public ImagemProduto toModel(EntityManager manager) {
        final Optional<Produto> imagemProduto = Optional.ofNullable(manager.find(Produto.class, idProduto));
        if (imagemProduto == null) {
            throw new ProdutoNotExistException("Produto não encontrado");
        }
        return new ImagemProduto(linkImagem, imagemProduto.get());
    }
}
