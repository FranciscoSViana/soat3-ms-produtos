package com.techchallenge.soat3msprodutos.application.produto.service;



import com.techchallenge.soat3msprodutos.adapter.produto.model.ProdutoContentResponse;
import com.techchallenge.soat3msprodutos.adapter.produto.model.ProdutoRequest;
import com.techchallenge.soat3msprodutos.adapter.produto.model.ProdutoResponse;
import com.techchallenge.soat3msprodutos.domain.model.ProdutoModel;

import java.util.List;
import java.util.UUID;

public interface ProdutoService {

    ProdutoResponse salvar(ProdutoRequest produtoRequest);

    ProdutoContentResponse buscarTodas(int pageNumber, int pageSize);

    ProdutoResponse buscarPorId(UUID uuid);

    ProdutoResponse atualizar(ProdutoRequest produtoRequest);

    ProdutoResponse delete(UUID produtoId);

    ProdutoModel obterProdutoPorUUID(UUID produtoId);

    List<ProdutoModel> findAllById(List<UUID> produtoIds);
}
