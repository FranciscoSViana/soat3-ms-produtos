package com.techchallenge.soat3msprodutos.application.produto.converter;

import com.techchallenge.soat3msprodutos.adapter.produto.model.ProdutoRequest;
import com.techchallenge.soat3msprodutos.adapter.produto.model.ProdutoResponse;
import com.techchallenge.soat3msprodutos.domain.enums.TipoCategoria;
import com.techchallenge.soat3msprodutos.domain.model.ProdutoModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ProdutoMapperTest {

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private ProdutoMapper produtoMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void produtoRequestToProduto() {
        // Given
        ProdutoRequest produtoRequest = new ProdutoRequest();
        produtoRequest.setNome("Produto Teste");
        produtoRequest.setDescricao("Descrição do produto teste");
        produtoRequest.setCategoria("Categoria teste");
        produtoRequest.setPreco(BigDecimal.valueOf(10.0));
        produtoRequest.setImagemBase64("Imagem teste");

        ProdutoModel produtoModelExpected = new ProdutoModel();
        produtoModelExpected.setNome("Produto Teste");
        produtoModelExpected.setDescricao("Descrição do produto teste");
        produtoModelExpected.setCategoria(TipoCategoria.BEBIDA);
        produtoModelExpected.setPreco(BigDecimal.valueOf(10.0));
        produtoModelExpected.setImagem("Imagem teste".getBytes());

        // When
        when(modelMapper.map(produtoRequest, ProdutoModel.class)).thenReturn(produtoModelExpected);

        ProdutoModel produtoModelActual = produtoMapper.produtoRequestToProduto(produtoRequest);

        // Then
        assertEquals(produtoModelExpected, produtoModelActual);
    }

    @Test
    void produtoToProdutoResponse() {
        // Given
        ProdutoModel produtoModel = new ProdutoModel();
        produtoModel.setId(UUID.randomUUID());
        produtoModel.setNome("Produto Teste");
        produtoModel.setDescricao("Descrição do produto teste");
        produtoModel.setCategoria(TipoCategoria.BEBIDA);
        produtoModel.setPreco(BigDecimal.valueOf(10.0));
        produtoModel.setImagem("Imagem teste".getBytes());

        ProdutoResponse produtoResponseExpected = ProdutoResponse.builder()
                .uuid(produtoModel.getId())
                .nome("Produto Teste")
                .descricao("Descrição do produto teste")
                .categoria(TipoCategoria.BEBIDA.getDescricao())
                .preco(BigDecimal.valueOf(10.0))
                .imagemBase64(Base64.getEncoder().encodeToString("Imagem teste".getBytes()))
                .build();

        // When
        ProdutoResponse produtoResponseActual = produtoMapper.produtoToProdutoResponse(produtoModel);

        // Then
        assertEquals(produtoResponseExpected, produtoResponseActual);
    }

    @Test
    void getProdutos() {
        // Given
        ProdutoModel produtoModel1 = new ProdutoModel();
        produtoModel1.setId(UUID.randomUUID());
        produtoModel1.setNome("Produto 1");
        produtoModel1.setDescricao("Descrição do produto 1");
        produtoModel1.setCategoria(TipoCategoria.BEBIDA);
        produtoModel1.setPreco(BigDecimal.valueOf(10.0));
        produtoModel1.setImagem("Imagem 1".getBytes());

        ProdutoModel produtoModel2 = new ProdutoModel();
        produtoModel2.setId(UUID.randomUUID());
        produtoModel2.setNome("Produto 2");
        produtoModel2.setDescricao("Descrição do produto 2");
        produtoModel2.setCategoria(TipoCategoria.BEBIDA);
        produtoModel2.setPreco(BigDecimal.valueOf(20.0));
        produtoModel2.setImagem("Imagem 2".getBytes());

        List<ProdutoModel> produtoModelList = Arrays.asList(produtoModel1, produtoModel2);

        ProdutoResponse produtoResponse1 = ProdutoResponse.builder()
                .uuid(produtoModel1.getId())
                .nome("Produto 1")
                .descricao("Descrição do produto 1")
                .categoria(TipoCategoria.BEBIDA.getDescricao())
                .preco(BigDecimal.valueOf(10.0))
                .imagemBase64(Base64.getEncoder().encodeToString("Imagem 1".getBytes()))
                .build();

        ProdutoResponse produtoResponse2 = ProdutoResponse.builder()
                .uuid(produtoModel2.getId())
                .nome("Produto 2")
                .descricao("Descrição do produto 2")
                .categoria(TipoCategoria.BEBIDA.getDescricao())
                .preco(BigDecimal.valueOf(20.0))
                .imagemBase64(Base64.getEncoder().encodeToString("Imagem 2".getBytes()))
                .build();

        // When
        List<ProdutoResponse> produtoResponseList = produtoMapper.getProdutos(produtoModelList);

        // Then
        assertEquals(2, produtoResponseList.size());
        assertEquals(produtoResponse1, produtoResponseList.get(0));
        assertEquals(produtoResponse2, produtoResponseList.get(1));
    }
}
