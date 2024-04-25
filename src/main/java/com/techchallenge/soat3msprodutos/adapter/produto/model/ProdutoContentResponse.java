package com.techchallenge.soat3msprodutos.adapter.produto.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
public class ProdutoContentResponse {
    private List<ProdutoResponse> content;
}
