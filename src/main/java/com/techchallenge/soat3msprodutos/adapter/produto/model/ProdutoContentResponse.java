package com.techchallenge.soat3msprodutos.adapter.produto.model;

import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class ProdutoContentResponse {

    private List<ProdutoResponse> content;

    public List<ProdutoResponse> getContent() {
        return content;
    }

    public void setContent(List<ProdutoResponse> content) {
        this.content = content;
    }

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
