package com.techchallenge.soat3msprodutos.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static java.lang.String.format;
import static java.util.Arrays.stream;

@Getter
@AllArgsConstructor
public enum TipoCategoria {

    LANCHE("Lanche"), ACOMPANHAMENTO("Acompanhamento"), BEBIDA("Bebida"), SOBREMESA("Sobremesa");

    private String descricao;

    public static TipoCategoria fromName(String name) {
        return stream(values())
                .filter(value -> value.name().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Categoria inválida: " + name));

    }
}
