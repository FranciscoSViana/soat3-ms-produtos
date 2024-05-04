package com.techchallenge.soat3msprodutos.application.produto.factory;

import com.techchallenge.soat3msprodutos.adapter.produto.model.ProdutoRequest;
import com.techchallenge.soat3msprodutos.application.produto.exception.NegocioException;
import com.techchallenge.soat3msprodutos.commons.utils.DataProvider;
import com.techchallenge.soat3msprodutos.domain.enums.TipoCategoria;
import com.techchallenge.soat3msprodutos.domain.model.ProdutoModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Base64;

import static com.techchallenge.soat3msprodutos.domain.enums.TipoCategoria.LANCHE;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ProdutoFactoryTest {

    @InjectMocks
    private ProdutoFactory produtoFactory;

    @Mock
    private DataProvider dataProvider;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void novo_ProdutoRequestValido_DeveRetornarProdutoModel() {
        ProdutoRequest produtoRequest = new ProdutoRequest();
        produtoRequest.setNome("Produto Teste");
        produtoRequest.setPreco(BigDecimal.valueOf(10.0));
        produtoRequest.setDescricao("Descrição do produto teste");
        produtoRequest.setCategoria(LANCHE.getDescricao());
        produtoRequest.setImagemBase64("aW1hZ2UgdGVzdGU=");


        when(dataProvider.obterDataHoraAtual()).thenReturn(LocalDateTime.parse("2024-05-01T12:00:00"));

        ProdutoModel produtoModel = produtoFactory.novo(produtoRequest);

        assertNotNull(produtoModel);
        assertNotNull(produtoModel.getId());
        assertEquals("Produto Teste", produtoModel.getNome());
        assertEquals(BigDecimal.valueOf(10.0), produtoModel.getPreco());
        assertEquals("Descrição do produto teste", produtoModel.getDescricao());
        assertEquals("aW1hZ2UgdGVzdGU=", Base64.getEncoder().encodeToString(produtoModel.getImagem()));
        assertEquals(TipoCategoria.fromName(LANCHE.getDescricao()), produtoModel.getCategoria());
        assertTrue(produtoModel.getStatus());
        assertEquals("2024-05-01T12:00", produtoModel.getDataHoraCriacao().toString());
    }

    @Test
    void novo_ProdutoRequestNulo_DeveLancarExcecao() {
        ProdutoRequest produtoRequest = null;

        assertThrows(NegocioException.class, () -> produtoFactory.novo(produtoRequest));
    }

    @Test
    void atualizar_ProdutoRequestValido_DeveAtualizarProdutoModel() {
        ProdutoRequest produtoRequest = new ProdutoRequest();
        produtoRequest.setNome("Novo Nome");
        produtoRequest.setPreco(BigDecimal.valueOf(20.0));
        produtoRequest.setDescricao("Nova descrição");
        produtoRequest.setCategoria(TipoCategoria.ACOMPANHAMENTO.name());
        produtoRequest.setImagemBase64("novaImagemBase64");

        ProdutoModel produtoModel = new ProdutoModel();
        produtoModel.setNome("Nome Antigo");
        produtoModel.setPreco(BigDecimal.valueOf(10.0));
        produtoModel.setDescricao("Descrição Antiga");
        produtoModel.setCategoria(TipoCategoria.LANCHE);
        produtoModel.setImagem("imagemAntiga".getBytes());
        produtoModel.setStatus(Boolean.TRUE);

        when(dataProvider.obterDataHoraAtual()).thenReturn(LocalDateTime.parse("2024-05-01T12:00:00"));

        ProdutoModel produtoAtualizado = produtoFactory.atualizar(produtoRequest, produtoModel);

        assertEquals("Novo Nome", produtoAtualizado.getNome());
        assertEquals(BigDecimal.valueOf(20.0), produtoAtualizado.getPreco());
        assertEquals("Nova descrição", produtoAtualizado.getDescricao());
        assertEquals("novaImagemBase64", Base64.getEncoder().encodeToString(produtoAtualizado.getImagem())); // Verificar se a imagem foi atualizada corretamente
        assertEquals(TipoCategoria.fromName(TipoCategoria.ACOMPANHAMENTO.getDescricao()), produtoAtualizado.getCategoria());
        assertTrue(produtoAtualizado.getStatus());
        assertEquals("2024-05-01T12:00", produtoAtualizado.getDataHoraAlteracao().toString());
    }

    @Test
    void atualizar_ProdutoRequestNulo_DeveLancarExcecao() {
        ProdutoRequest produtoRequest = null;
        ProdutoModel produtoModel = new ProdutoModel();

        assertThrows(NegocioException.class, () -> produtoFactory.atualizar(produtoRequest, produtoModel));
    }

    @Test
    void delete_ProdutoValido_DeveMarcarProdutoComoInativo() {
        ProdutoModel produtoModel = new ProdutoModel();
        produtoModel.setStatus(true); // Produto ativo

        when(dataProvider.obterDataHoraAtual()).thenReturn(LocalDateTime.parse("2024-05-01T12:00:00"));

        ProdutoModel produtoDeletado = produtoFactory.delete(produtoModel);

        assertFalse(produtoDeletado.getStatus()); // Verificar se o produto está marcado como inativo
        assertEquals("2024-05-01T12:00", produtoDeletado.getDataHoraAlteracao().toString());
    }

    @Test
    void delete_ProdutoNulo_DeveLancarExcecao() {
        ProdutoModel produtoModel = null;

        assertThrows(NegocioException.class, () -> produtoFactory.delete(produtoModel));
    }

    @Test
    void novo_ImagemBase64Nula_DeveLancarExcecao() {
        ProdutoRequest produtoRequest = new ProdutoRequest();
        produtoRequest.setNome("Produto Teste");
        produtoRequest.setPreco(BigDecimal.valueOf(10.0));
        produtoRequest.setDescricao("Descrição do produto teste");
        produtoRequest.setCategoria(LANCHE.getDescricao());
        produtoRequest.setImagemBase64(null);

        assertThrows(NullPointerException.class, () -> produtoFactory.novo(produtoRequest));
    }

    @Test
    void atualizar_ImagemBase64Nula_DeveLancarExcecao() {
        ProdutoModel produtoModel = new ProdutoModel();

        assertThrows(NegocioException.class, () -> produtoFactory.atualizar(null, produtoModel));
    }
}
