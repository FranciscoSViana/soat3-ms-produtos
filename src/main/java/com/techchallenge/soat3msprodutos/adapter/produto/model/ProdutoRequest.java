package com.techchallenge.soat3msprodutos.adapter.produto.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoRequest {

    private UUID uuid;
    private String nome;
    private String descricao;
    private String categoria;
    private BigDecimal preco;
    private String imagemBase64;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoRequest that = (ProdutoRequest) o;
        return Objects.equals(uuid, that.uuid) && Objects.equals(nome, that.nome) && Objects.equals(descricao, that.descricao) && Objects.equals(categoria, that.categoria) && Objects.equals(preco, that.preco) && Objects.equals(imagemBase64, that.imagemBase64);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, nome, descricao, categoria, preco, imagemBase64);
    }
}
