package com.techchallenge.soat3msprodutos.adapter.produto.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ProdutoResponseTest {

    @Test
    void testBuilder() {
        UUID uuid = UUID.randomUUID();
        String nome = "Produto Teste";
        String descricao = "Descrição do produto";
        String categoria = "Categoria do produto";
        BigDecimal preco = BigDecimal.valueOf(99.99);
        String imagemBase64 = "Imagem em base64";

        ProdutoResponse produtoResponse = ProdutoResponse.builder()
                .uuid(uuid)
                .nome(nome)
                .descricao(descricao)
                .categoria(categoria)
                .preco(preco)
                .imagemBase64(imagemBase64)
                .build();

        assertEquals(uuid, produtoResponse.getUuid());
        assertEquals(nome, produtoResponse.getNome());
        assertEquals(descricao, produtoResponse.getDescricao());
        assertEquals(categoria, produtoResponse.getCategoria());
        assertEquals(preco, produtoResponse.getPreco());
        assertEquals(imagemBase64, produtoResponse.getImagemBase64());
    }

    @Test
    void testAllArgsConstructor() {
        UUID uuid = UUID.randomUUID();
        String nome = "Produto Teste";
        String descricao = "Descrição do produto";
        String categoria = "Categoria do produto";
        BigDecimal preco = BigDecimal.valueOf(99.99);
        String imagemBase64 = "Imagem em base64";

        ProdutoResponse produtoResponse = new ProdutoResponse(uuid, nome, descricao, categoria, preco, imagemBase64);

        assertEquals(uuid, produtoResponse.getUuid());
        assertEquals(nome, produtoResponse.getNome());
        assertEquals(descricao, produtoResponse.getDescricao());
        assertEquals(categoria, produtoResponse.getCategoria());
        assertEquals(preco, produtoResponse.getPreco());
        assertEquals(imagemBase64, produtoResponse.getImagemBase64());
    }

    @Test
    void testToString() {
        UUID uuid = UUID.randomUUID();
        String nome = "Produto Teste";
        String descricao = "Descrição do produto";
        String categoria = "Categoria do produto";
        BigDecimal preco = BigDecimal.valueOf(99.99);
        String imagemBase64 = "Imagem em base64";

        ProdutoResponse produtoResponse = ProdutoResponse.builder()
                .uuid(uuid)
                .nome(nome)
                .descricao(descricao)
                .categoria(categoria)
                .preco(preco)
                .imagemBase64(imagemBase64)
                .build();

        assertNotNull(produtoResponse.toString());
    }

    @Test
    void testEqualsAndHashCode() {
        UUID uuid1 = UUID.randomUUID();
        String nome1 = "Produto Teste";
        String descricao1 = "Descrição do produto";
        String categoria1 = "Categoria do produto";
        BigDecimal preco1 = BigDecimal.valueOf(99.99);
        String imagemBase641 = "Imagem em base64";

        UUID uuid2 = UUID.randomUUID();
        String nome2 = "Produto Teste";
        String descricao2 = "Descrição do produto";
        String categoria2 = "Categoria do produto";
        BigDecimal preco2 = BigDecimal.valueOf(99.99);
        String imagemBase642 = "Imagem em base64";

        ProdutoResponse produtoResponse1 = new ProdutoResponse(uuid1, nome1, descricao1, categoria1, preco1, imagemBase641);
        ProdutoResponse produtoResponse2 = new ProdutoResponse(uuid1, nome1, descricao1, categoria1, preco1, imagemBase641);
        ProdutoResponse produtoResponse3 = new ProdutoResponse(uuid2, nome2, descricao2, categoria2, preco2, imagemBase642);
        ProdutoResponse produtoResponse4 = new ProdutoResponse();

        assertEquals(produtoResponse1, produtoResponse2);
        assertEquals(produtoResponse1.hashCode(), produtoResponse2.hashCode());

        assertNotEquals(produtoResponse1, produtoResponse3);
        assertNotEquals(produtoResponse1.hashCode(), produtoResponse3.hashCode());

        assertNotEquals(null, produtoResponse1);
        assertNotEquals(produtoResponse1, new Object());

        assertEquals(887503681, produtoResponse4.hashCode());
    }

    @Test
    void testGetterAndSetter() {
        UUID uuid = UUID.randomUUID();
        String nome = "Produto Teste";
        String descricao = "Descrição do produto";
        String categoria = "Categoria do produto";
        BigDecimal preco = BigDecimal.valueOf(99.99);
        String imagemBase64 = "Imagem em base64";

        ProdutoResponse produtoResponse = new ProdutoResponse();

        produtoResponse.setUuid(uuid);
        produtoResponse.setNome(nome);
        produtoResponse.setDescricao(descricao);
        produtoResponse.setCategoria(categoria);
        produtoResponse.setPreco(preco);
        produtoResponse.setImagemBase64(imagemBase64);

        assertEquals(uuid, produtoResponse.getUuid());
        assertEquals(nome, produtoResponse.getNome());
        assertEquals(descricao, produtoResponse.getDescricao());
        assertEquals(categoria, produtoResponse.getCategoria());
        assertEquals(preco, produtoResponse.getPreco());
        assertEquals(imagemBase64, produtoResponse.getImagemBase64());
    }
}
