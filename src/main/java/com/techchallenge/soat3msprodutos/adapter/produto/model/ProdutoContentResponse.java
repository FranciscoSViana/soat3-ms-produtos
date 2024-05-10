package com.techchallenge.soat3msprodutos.adapter.produto.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
@EqualsAndHashCode
public class ProdutoContentResponse {
    private List<ProdutoResponse> content;
}
