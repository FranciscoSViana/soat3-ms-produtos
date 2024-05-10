package com.techchallenge.soat3msprodutos.adapter.produto.model;

import lombok.*;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class ProdutoContentResponse {
    private List<ProdutoResponse> content;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoContentResponse that = (ProdutoContentResponse) o;
        return Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(content);
    }
}
