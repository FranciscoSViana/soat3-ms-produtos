package com.techchallenge.soat3msprodutos.adapter.produto.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class ProdutoContentResponse {
    
    private List<ProdutoResponse> content;
}
