package com.techchallenge.soat3msprodutos.application.produto.factory;

import com.techchallenge.soat3msprodutos.adapter.produto.model.ProdutoRequest;
import com.techchallenge.soat3msprodutos.application.produto.exception.NegocioException;
import com.techchallenge.soat3msprodutos.commons.utils.DataProvider;
import com.techchallenge.soat3msprodutos.domain.enums.TipoCategoria;
import com.techchallenge.soat3msprodutos.domain.model.ProdutoModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Objects;
import java.util.UUID;

@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ProdutoFactory {

    private static final String PRODUTO_NAO_PODE_SER_NULO = "Produto não pode ser nulo";

    private final DataProvider dataProvider;


    public ProdutoModel novo(ProdutoRequest produtoRequest) {

        if (Objects.isNull(produtoRequest)) {
            throw new NegocioException(PRODUTO_NAO_PODE_SER_NULO);
        }

        return ProdutoModel.
                builder()
                .id(UUID.randomUUID())
                .nome(produtoRequest.getNome())
                .preco(produtoRequest.getPreco())
                .dataHoraCriacao(dataProvider.obterDataHoraAtual())
                .descricao(produtoRequest.getDescricao())
                .imagem(Base64.getDecoder().decode(produtoRequest.getImagemBase64()))
                .categoria(TipoCategoria.fromName(produtoRequest.getCategoria()))
                .status(Boolean.TRUE)
                .build();
    }

    public ProdutoModel atualizar(ProdutoRequest produtoRequest, ProdutoModel produtoModel) {

        if (Objects.isNull(produtoRequest)) {
            throw new NegocioException(PRODUTO_NAO_PODE_SER_NULO);
        }

        produtoModel.setNome(produtoRequest.getNome());
        produtoModel.setPreco(produtoRequest.getPreco());
        produtoModel.setDescricao(produtoRequest.getDescricao());
        produtoModel.setImagem(Base64.getDecoder().decode(produtoRequest.getImagemBase64()));
        produtoModel.setCategoria(TipoCategoria.fromName(produtoRequest.getCategoria()));
        produtoModel.setDataHoraAlteracao(dataProvider.obterDataHoraAtual());

        return produtoModel;
    }

    public ProdutoModel delete(ProdutoModel produtoModel) {

        if (Objects.isNull(produtoModel)) {
            throw new NegocioException(PRODUTO_NAO_PODE_SER_NULO);
        }

        produtoModel.setDataHoraAlteracao(dataProvider.obterDataHoraAtual());
        produtoModel.setStatus(Boolean.FALSE);
        return produtoModel;
    }
}
