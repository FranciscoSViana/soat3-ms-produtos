package com.techchallenge.soat3msprodutos.adapter.produto.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoContentResponseTest {

    @Test
    void testBuilder() {
        List<ProdutoResponse> content = new ArrayList<>();
        ProdutoResponse produtoResponse1 = new ProdutoResponse();
        ProdutoResponse produtoResponse2 = new ProdutoResponse();
        content.add(produtoResponse1);
        content.add(produtoResponse2);

        ProdutoContentResponse produtoContentResponse = ProdutoContentResponse.builder()
                .content(content)
                .build();

        assertNotNull(produtoContentResponse.getContent());
        assertEquals(2, produtoContentResponse.getContent().size());
        assertEquals(produtoResponse1, produtoContentResponse.getContent().get(0));
        assertEquals(produtoResponse2, produtoContentResponse.getContent().get(1));
    }

    @Test
    void testAllArgsConstructor() {
        List<ProdutoResponse> content = new ArrayList<>();
        ProdutoResponse produtoResponse1 = new ProdutoResponse();
        ProdutoResponse produtoResponse2 = new ProdutoResponse();
        content.add(produtoResponse1);
        content.add(produtoResponse2);

        ProdutoContentResponse produtoContentResponse = new ProdutoContentResponse(content);

        assertNotNull(produtoContentResponse.getContent());
        assertEquals(2, produtoContentResponse.getContent().size());
        assertEquals(produtoResponse1, produtoContentResponse.getContent().get(0));
        assertEquals(produtoResponse2, produtoContentResponse.getContent().get(1));
    }

    @Test
    void testEmptyConstructor() {
        ProdutoContentResponse produtoContentResponse = ProdutoContentResponse
                .builder().content(Arrays.asList(new ProdutoResponse()))
                .build();
        assertNotNull(produtoContentResponse);
        assertNotNull(produtoContentResponse.getContent());
        assertEquals(1, produtoContentResponse.getContent().size());
    }


    @Test
    void testGetterAndSetter() {
        ProdutoContentResponse produtoContentResponse = new ProdutoContentResponse();
        List<ProdutoResponse> content = new ArrayList<>();
        ProdutoResponse produtoResponse1 = new ProdutoResponse();
        ProdutoResponse produtoResponse2 = new ProdutoResponse();
        content.add(produtoResponse1);
        content.add(produtoResponse2);

        produtoContentResponse.setContent(content);

        assertNotNull(produtoContentResponse.getContent());
        assertEquals(2, produtoContentResponse.getContent().size());
        assertEquals(produtoResponse1, produtoContentResponse.getContent().get(0));
        assertEquals(produtoResponse2, produtoContentResponse.getContent().get(1));
    }
    @Test
    void testEquals() {
        List<ProdutoResponse> content1 = new ArrayList<>();
        List<ProdutoResponse> content2 = new ArrayList<>();

        ProdutoResponse produtoResponse1 = ProdutoResponse.builder()
                .uuid(UUID.randomUUID())
                .nome("Produto 1")
                .descricao("Descrição do produto 1")
                .categoria("Categoria 1")
                .preco(BigDecimal.valueOf(10.0))
                .imagemBase64("Imagem 1")
                .build();

        ProdutoResponse produtoResponse2 = ProdutoResponse.builder()
                .uuid(UUID.randomUUID())
                .nome("Produto 2")
                .descricao("Descrição do produto 2")
                .categoria("Categoria 2")
                .preco(BigDecimal.valueOf(20.0))
                .imagemBase64("Imagem 2")
                .build();

        content1.add(produtoResponse1);
        content2.add(produtoResponse1);

        ProdutoContentResponse produtoContentResponse1 = new ProdutoContentResponse(content1);
        ProdutoContentResponse produtoContentResponse2 = new ProdutoContentResponse(content2);

        assertEquals(produtoContentResponse1, produtoContentResponse2);
    }




}
