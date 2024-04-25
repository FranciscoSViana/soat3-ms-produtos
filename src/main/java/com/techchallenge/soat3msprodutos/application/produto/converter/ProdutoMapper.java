package com.techchallenge.soat3msprodutos.application.produto.converter;

import com.techchallenge.soat3msprodutos.adapter.produto.model.ProdutoRequest;
import com.techchallenge.soat3msprodutos.adapter.produto.model.ProdutoResponse;
import com.techchallenge.soat3msprodutos.domain.model.ProdutoModel;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ProdutoMapper {

    private final ModelMapper modelMapper;


    public ProdutoModel produtoRequestToProduto(ProdutoRequest produtoRequest) {
        return modelMapper.map(produtoRequest, ProdutoModel.class);
    }

    public ProdutoResponse produtoToProdutoResponse(ProdutoModel produto) {
        return ProdutoResponse.builder()
                .uuid(produto.getId())
                .categoria(produto.getCategoria().getDescricao())
                .descricao(produto.getDescricao())
                .preco(produto.getPreco())
                .nome(produto.getNome())
                .imagemBase64(Base64.getEncoder().encodeToString(produto.getImagem()))
                .build();
    }

    public List<ProdutoResponse> getProdutos(List<ProdutoModel> list) {
        List<ProdutoResponse> produtos = new ArrayList<>();
        list.forEach(item -> {
            ProdutoResponse produtoResponse = produtoToProdutoResponse(item);
            produtos.add(produtoResponse);
        });

        return produtos;
    }

}
