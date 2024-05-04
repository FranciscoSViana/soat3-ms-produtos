package com.techchallenge.soat3msprodutos.application.produto.service;

import com.techchallenge.soat3msprodutos.adapter.produto.model.ProdutoContentResponse;
import com.techchallenge.soat3msprodutos.adapter.produto.model.ProdutoRequest;
import com.techchallenge.soat3msprodutos.adapter.produto.model.ProdutoResponse;
import com.techchallenge.soat3msprodutos.application.produto.converter.ProdutoMapper;
import com.techchallenge.soat3msprodutos.application.produto.exception.NegocioException;
import com.techchallenge.soat3msprodutos.application.produto.factory.ProdutoFactory;
import com.techchallenge.soat3msprodutos.domain.enums.TipoCategoria;
import com.techchallenge.soat3msprodutos.domain.model.ProdutoModel;
import com.techchallenge.soat3msprodutos.infrastruture.produto.repository.ProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.PageRequest;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ProdutoServiceImplTest {

    @InjectMocks
    private ProdutoServiceImpl produtoService;

    @Mock
    private ProdutoRepository produtoRepository;

    @Mock
    private ProdutoFactory produtoFactory;

    @Mock
    private ProdutoMapper produtoMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void salvar_DeveRetornarProdutoResponse() {
        ProdutoRequest produtoRequest = ProdutoRequest.builder()
                .uuid(UUID.randomUUID())
                .nome("Produto Teste")
                .descricao("Descrição do produto")
                .categoria(TipoCategoria.LANCHE.getDescricao())
                .preco(BigDecimal.valueOf(10.0))
                .imagemBase64("Imagem em Base64")
                .build();

        ProdutoModel produtoModel = ProdutoModel.builder()
                .id(produtoRequest.getUuid())
                .categoria(TipoCategoria.LANCHE)
                .imagem(new byte[]{})
                .nome(produtoRequest.getNome())
                .descricao(produtoRequest.getDescricao())
                .preco(produtoRequest.getPreco())
                .build();

        when(produtoRepository.save(any(ProdutoModel.class))).thenReturn(produtoModel);

        when(produtoFactory.novo(produtoRequest)).thenReturn(produtoModel);

        when(produtoMapper.produtoToProdutoResponse(Mockito.any(ProdutoModel.class))).thenReturn(ProdutoResponse.builder()
                .uuid(produtoModel.getId())
                .nome(produtoModel.getNome())
                .descricao(produtoModel.getDescricao())
                .categoria(produtoModel.getCategoria().getDescricao())
                .preco(produtoModel.getPreco())
                .imagemBase64("Imagem em Base64")
                .build());

        ProdutoResponse produtoResponse = produtoService.salvar(produtoRequest);

        assertNotNull(produtoResponse);
        assertEquals(produtoRequest.getUuid(), produtoResponse.getUuid());
        assertEquals(produtoRequest.getNome(), produtoResponse.getNome());
        assertEquals(produtoRequest.getDescricao(), produtoResponse.getDescricao());
        assertEquals(produtoRequest.getCategoria(), produtoResponse.getCategoria());
        assertEquals(produtoRequest.getPreco(), produtoResponse.getPreco());
        assertEquals(produtoRequest.getImagemBase64(), produtoResponse.getImagemBase64());
    }

    @Test
    void buscarTodas_DeveRetornarProdutoContentResponse() {
        List<ProdutoModel> produtos = Collections.emptyList();
        when(produtoRepository.findByStatusTrue(any(PageRequest.class))).thenReturn(produtos);

        ProdutoContentResponse produtoContentResponse = produtoService.buscarTodas(0, 10);

        assertNotNull(produtoContentResponse);
        assertTrue(produtoContentResponse.getContent().isEmpty());
    }

    @Test
    void buscarPorId_QuandoProdutoExiste_DeveRetornarProdutoResponse() {
        UUID uuid = UUID.randomUUID();
        ProdutoModel produtoModel = new ProdutoModel();
        produtoModel.setId(uuid);
        produtoModel.setNome("Produto Teste");
        produtoModel.setPreco(BigDecimal.valueOf(10.0));

        when(produtoRepository.findById(uuid)).thenReturn(Optional.of(produtoModel));

        when(produtoMapper.produtoToProdutoResponse(Mockito.any(ProdutoModel.class))).thenReturn(ProdutoResponse.builder()
                .uuid(produtoModel.getId())
                .nome(produtoModel.getNome())
                .preco(produtoModel.getPreco())
                .build());

        ProdutoResponse produtoResponse = produtoService.buscarPorId(uuid);

        assertNotNull(produtoResponse);
        assertEquals(uuid, produtoResponse.getUuid());
        assertEquals("Produto Teste", produtoResponse.getNome());
        assertEquals(BigDecimal.valueOf(10.0), produtoResponse.getPreco());
    }

    @Test
    void buscarPorId_QuandoProdutoNaoExiste_DeveLancarExcecao() {
        UUID uuid = UUID.randomUUID();
        when(produtoRepository.findById(uuid)).thenReturn(Optional.empty());

        assertThrows(NegocioException.class, () -> produtoService.buscarPorId(uuid));
    }

    @Test
    void atualizar_DeveRetornarProdutoResponse() {
        ProdutoRequest produtoRequest = new ProdutoRequest();
        UUID uuid = UUID.randomUUID();
        produtoRequest.setUuid(uuid);
        produtoRequest.setNome("Produto Atualizado");
        produtoRequest.setPreco(BigDecimal.valueOf(20.0));

        ProdutoModel produtoModel = new ProdutoModel();
        produtoModel.setId(uuid);
        produtoModel.setNome("Produto Antigo");
        produtoModel.setPreco(BigDecimal.valueOf(10.0));

        ProdutoModel produtoAtualizado = new ProdutoModel();
        produtoAtualizado.setId(uuid);
        produtoAtualizado.setNome("Produto Atualizado");
        produtoAtualizado.setPreco(BigDecimal.valueOf(20.0));

        when(produtoRepository.findById(uuid)).thenReturn(Optional.of(produtoModel));

        when(produtoFactory.atualizar(produtoRequest, produtoModel)).thenReturn(produtoAtualizado);

        when(produtoRepository.save(produtoAtualizado)).thenReturn(produtoAtualizado);

        when(produtoMapper.produtoToProdutoResponse(produtoAtualizado)).thenReturn(new ProdutoResponse(uuid, "Produto Atualizado", null, null, BigDecimal.valueOf(20.0), null));

        ProdutoResponse produtoResponse = produtoService.atualizar(produtoRequest);

        assertNotNull(produtoResponse);
        assertEquals(uuid, produtoResponse.getUuid());
        assertEquals("Produto Atualizado", produtoResponse.getNome());
        assertEquals(BigDecimal.valueOf(20.0), produtoResponse.getPreco());
    }


    @Test
    void delete_DeveRetornarProdutoResponse() {
        UUID uuid = UUID.randomUUID();
        ProdutoModel produtoModel = new ProdutoModel();
        produtoModel.setId(uuid);
        produtoModel.setNome("Produto Teste");
        produtoModel.setPreco(BigDecimal.valueOf(10.0));

        when(produtoRepository.findById(uuid)).thenReturn(Optional.of(produtoModel));
        when(produtoRepository.save(produtoModel)).thenReturn(produtoModel);
        when(produtoMapper.produtoToProdutoResponse(produtoModel)).thenReturn(new ProdutoResponse(uuid, "Produto Teste", null, null, BigDecimal.valueOf(10.0), null));

        ProdutoResponse produtoResponse = produtoService.delete(uuid);

        assertNotNull(produtoResponse);
        assertEquals(uuid, produtoResponse.getUuid());
        assertEquals("Produto Teste", produtoResponse.getNome());
        assertEquals(BigDecimal.valueOf(10.0), produtoResponse.getPreco());
    }

    @Test
    void delete_QuandoProdutoNaoExiste_DeveLancarExcecao() {
        UUID uuid = UUID.randomUUID();
        when(produtoRepository.findById(uuid)).thenReturn(Optional.empty());

        assertThrows(NegocioException.class, () -> produtoService.delete(uuid));
    }


}
