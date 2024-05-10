package com.techchallenge.soat3msprodutos.adapter.produto.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoRequestTest {

    @Test
    void testBuilder() {
        UUID uuid = UUID.randomUUID();
        String nome = "Produto Teste";
        String descricao = "Descrição do produto";
        String categoria = "Categoria do produto";
        BigDecimal preco = BigDecimal.valueOf(99.99);
        String imagemBase64 = "Imagem em base64";

        ProdutoRequest produtoRequest = ProdutoRequest.builder()
                .uuid(uuid)
                .nome(nome)
                .descricao(descricao)
                .categoria(categoria)
                .preco(preco)
                .imagemBase64(imagemBase64)
                .build();

        assertEquals(uuid, produtoRequest.getUuid());
        assertEquals(nome, produtoRequest.getNome());
        assertEquals(descricao, produtoRequest.getDescricao());
        assertEquals(categoria, produtoRequest.getCategoria());
        assertEquals(preco, produtoRequest.getPreco());
        assertEquals(imagemBase64, produtoRequest.getImagemBase64());
    }

    @Test
    void testAllArgsConstructor() {
        UUID uuid = UUID.randomUUID();
        String nome = "Produto Teste";
        String descricao = "Descrição do produto";
        String categoria = "Categoria do produto";
        BigDecimal preco = BigDecimal.valueOf(99.99);
        String imagemBase64 = "Imagem em base64";

        ProdutoRequest produtoRequest = new ProdutoRequest(uuid, nome, descricao, categoria, preco, imagemBase64);

        assertEquals(uuid, produtoRequest.getUuid());
        assertEquals(nome, produtoRequest.getNome());
        assertEquals(descricao, produtoRequest.getDescricao());
        assertEquals(categoria, produtoRequest.getCategoria());
        assertEquals(preco, produtoRequest.getPreco());
        assertEquals(imagemBase64, produtoRequest.getImagemBase64());
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

        ProdutoRequest produtoRequest1 = new ProdutoRequest(uuid1, nome1, descricao1, categoria1, preco1, imagemBase641);
        ProdutoRequest produtoRequest2 = new ProdutoRequest(uuid1, nome1, descricao1, categoria1, preco1, imagemBase641);
        ProdutoRequest produtoRequest3 = new ProdutoRequest(uuid2, nome2, descricao2, categoria2, preco2, imagemBase642);
        ProdutoRequest produtoRequest4 = new ProdutoRequest();

        assertEquals(produtoRequest1, produtoRequest2);
        assertEquals(produtoRequest1.hashCode(), produtoRequest2.hashCode());

        assertNotEquals(produtoRequest1, produtoRequest3);
        assertNotEquals(produtoRequest1.hashCode(), produtoRequest3.hashCode());

        assertNotEquals(null, produtoRequest1);
        assertNotEquals(produtoRequest1, new Object());

        assertEquals(887503681, produtoRequest4.hashCode());
    }

    @Test
    void testEmptyConstructor() {
        ProdutoRequest produtoRequest = new ProdutoRequest();
        assertNotNull(produtoRequest);
    }

    @Test
    void testPartialConstructor() {
        UUID uuid = UUID.randomUUID();
        ProdutoRequest produtoRequest = new ProdutoRequest(uuid, "Produto", "Descrição", "Categoria", BigDecimal.TEN, "Imagem");
        assertNotNull(produtoRequest);
        assertEquals(uuid, produtoRequest.getUuid());
        assertEquals("Produto", produtoRequest.getNome());
        assertEquals("Descrição", produtoRequest.getDescricao());
        assertEquals("Categoria", produtoRequest.getCategoria());
        assertEquals(BigDecimal.TEN, produtoRequest.getPreco());
        assertEquals("Imagem", produtoRequest.getImagemBase64());
    }

    @Test
    void testToString() {
        UUID uuid = UUID.randomUUID();
        String nome = "Produto Teste";
        String descricao = "Descrição do produto";
        String categoria = "Categoria do produto";
        BigDecimal preco = BigDecimal.valueOf(99.99);
        String imagemBase64 = "Imagem em base64";

        ProdutoRequest produtoRequest = ProdutoRequest.builder()
                .uuid(uuid)
                .nome(nome)
                .descricao(descricao)
                .categoria(categoria)
                .preco(preco)
                .imagemBase64(imagemBase64)
                .build();

        assertNotNull(produtoRequest.toString());
    }

    @Test
    void testNoArgsConstructor() {
        ProdutoRequest produtoRequest = new ProdutoRequest();
        assertNotNull(produtoRequest);
    }

    @Test
    void testGetterAndSetter() {
        UUID uuid = UUID.randomUUID();
        String nome = "Produto Teste";
        String descricao = "Descrição do produto";
        String categoria = "Categoria do produto";
        BigDecimal preco = BigDecimal.valueOf(99.99);
        String imagemBase64 = "Imagem em base64";

        ProdutoRequest produtoRequest = new ProdutoRequest();

        produtoRequest.setUuid(uuid);
        produtoRequest.setNome(nome);
        produtoRequest.setDescricao(descricao);
        produtoRequest.setCategoria(categoria);
        produtoRequest.setPreco(preco);
        produtoRequest.setImagemBase64(imagemBase64);

        assertEquals(uuid, produtoRequest.getUuid());
        assertEquals(nome, produtoRequest.getNome());
        assertEquals(descricao, produtoRequest.getDescricao());
        assertEquals(categoria, produtoRequest.getCategoria());
        assertEquals(preco, produtoRequest.getPreco());
        assertEquals(imagemBase64, produtoRequest.getImagemBase64());
    }
}
