package com.techchallenge.soat3msprodutos.domain.model;

import com.techchallenge.soat3msprodutos.domain.enums.TipoCategoria;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoModelTest {

    @Test
    void testEquals() {
        ProdutoModel produto1 = ProdutoModel.builder()
                .id(UUID.randomUUID())
                .categoria(TipoCategoria.LANCHE)
                .nome("Produto Teste")
                .descricao("Descrição do produto")
                .preco(BigDecimal.valueOf(10.0))
                .imagem(new byte[]{})
                .dataHoraCriacao(LocalDateTime.now())
                .dataHoraAlteracao(LocalDateTime.now())
                .status(true)
                .build();

        ProdutoModel produto2 = ProdutoModel.builder()
                .id(produto1.getId())
                .categoria(produto1.getCategoria())
                .nome(produto1.getNome())
                .descricao(produto1.getDescricao())
                .preco(produto1.getPreco())
                .imagem(produto1.getImagem())
                .dataHoraCriacao(produto1.getDataHoraCriacao())
                .dataHoraAlteracao(produto1.getDataHoraAlteracao())
                .status(produto1.getStatus())
                .build();

        assertEquals(produto1, produto2);
    }

    @Test
    void testHashCode() {
        ProdutoModel produto = ProdutoModel.builder()
                .id(UUID.randomUUID())
                .categoria(TipoCategoria.LANCHE)
                .nome("Produto Teste")
                .descricao("Descrição do produto")
                .preco(BigDecimal.valueOf(10.0))
                .imagem(new byte[]{})
                .dataHoraCriacao(LocalDateTime.now())
                .dataHoraAlteracao(LocalDateTime.now())
                .status(true)
                .build();

        assertNotNull(produto.hashCode());
    }

    @Test
    void testGetId() {
        UUID id = UUID.randomUUID();
        ProdutoModel produto = new ProdutoModel();
        produto.setId(id);
        assertEquals(id, produto.getId());
    }

    @Test
    void testGetCategoria() {
        TipoCategoria categoria = TipoCategoria.LANCHE;
        ProdutoModel produto = new ProdutoModel();
        produto.setCategoria(categoria);
        assertEquals(categoria, produto.getCategoria());
    }

    @Test
    void testGetImagem() {
        byte[] imagem = new byte[]{1, 2, 3};
        ProdutoModel produto = new ProdutoModel();
        produto.setImagem(imagem);
        assertArrayEquals(imagem, produto.getImagem());
    }

    @Test
    void testGetNome() {
        String nome = "Produto Teste";
        ProdutoModel produto = new ProdutoModel();
        produto.setNome(nome);
        assertEquals(nome, produto.getNome());
    }

    @Test
    void testGetDescricao() {
        String descricao = "Descrição do produto";
        ProdutoModel produto = new ProdutoModel();
        produto.setDescricao(descricao);
        assertEquals(descricao, produto.getDescricao());
    }

    @Test
    void testGetDataHoraCriacao() {
        LocalDateTime dataHoraCriacao = LocalDateTime.now();
        ProdutoModel produto = new ProdutoModel();
        produto.setDataHoraCriacao(dataHoraCriacao);
        assertEquals(dataHoraCriacao, produto.getDataHoraCriacao());
    }

    @Test
    void testGetPreco() {
        BigDecimal preco = BigDecimal.valueOf(10.0);
        ProdutoModel produto = new ProdutoModel();
        produto.setPreco(preco);
        assertEquals(preco, produto.getPreco());
    }

    @Test
    void testGetDataHoraAlteracao() {
        LocalDateTime dataHoraAlteracao = LocalDateTime.now();
        ProdutoModel produto = new ProdutoModel();
        produto.setDataHoraAlteracao(dataHoraAlteracao);
        assertEquals(dataHoraAlteracao, produto.getDataHoraAlteracao());
    }

    @Test
    void testGetStatus() {
        Boolean status = true;
        ProdutoModel produto = new ProdutoModel();
        produto.setStatus(status);
        assertEquals(status, produto.getStatus());
    }

    @Test
    void testSetId() {
        UUID id = UUID.randomUUID();
        ProdutoModel produto = new ProdutoModel();
        produto.setId(id);
        assertEquals(id, produto.getId());
    }

    @Test
    void testSetCategoria() {
        TipoCategoria categoria = TipoCategoria.LANCHE;
        ProdutoModel produto = new ProdutoModel();
        produto.setCategoria(categoria);
        assertEquals(categoria, produto.getCategoria());
    }

    @Test
    void testSetImagem() {
        byte[] imagem = new byte[]{1, 2, 3};
        ProdutoModel produto = new ProdutoModel();
        produto.setImagem(imagem);
        assertArrayEquals(imagem, produto.getImagem());
    }

    @Test
    void testSetNome() {
        String nome = "Produto Teste";
        ProdutoModel produto = new ProdutoModel();
        produto.setNome(nome);
        assertEquals(nome, produto.getNome());
    }

    @Test
    void testSetDescricao() {
        String descricao = "Descrição do produto";
        ProdutoModel produto = new ProdutoModel();
        produto.setDescricao(descricao);
        assertEquals(descricao, produto.getDescricao());
    }

    @Test
    void testSetDataHoraCriacao() {
        LocalDateTime dataHoraCriacao = LocalDateTime.now();
        ProdutoModel produto = new ProdutoModel();
        produto.setDataHoraCriacao(dataHoraCriacao);
        assertEquals(dataHoraCriacao, produto.getDataHoraCriacao());
    }

    @Test
    void testSetPreco() {
        BigDecimal preco = BigDecimal.valueOf(10.0);
        ProdutoModel produto = new ProdutoModel();
        produto.setPreco(preco);
        assertEquals(preco, produto.getPreco());
    }

    @Test
    void testSetDataHoraAlteracao() {
        LocalDateTime dataHoraAlteracao = LocalDateTime.now();
        ProdutoModel produto = new ProdutoModel();
        produto.setDataHoraAlteracao(dataHoraAlteracao);
        assertEquals(dataHoraAlteracao, produto.getDataHoraAlteracao());
    }

    @Test
    void testSetStatus() {
        Boolean status = true;
        ProdutoModel produto = new ProdutoModel();
        produto.setStatus(status);
        assertEquals(status, produto.getStatus());
    }

}
