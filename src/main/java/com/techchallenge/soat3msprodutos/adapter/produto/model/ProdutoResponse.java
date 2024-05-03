package com.techchallenge.soat3msprodutos.adapter.produto.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoResponse {

    private UUID uuid;
    private String nome;
    private String descricao;
    private String categoria;
    private BigDecimal preco;
    private String imagemBase64;

}
