package com.techchallenge.soat3msprodutos.adapter.produto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techchallenge.soat3msprodutos.adapter.produto.model.ProdutoContentResponse;
import com.techchallenge.soat3msprodutos.adapter.produto.model.ProdutoRequest;
import com.techchallenge.soat3msprodutos.adapter.produto.model.ProdutoResponse;
import com.techchallenge.soat3msprodutos.application.produto.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProdutoControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProdutoService produtoService;

    @Test
    void deveriaRetornarListaDeProdutosQuandoSolicitado() throws Exception {
        ProdutoContentResponse response = ProdutoContentResponse.builder().content(Collections.emptyList()).build();
        when(produtoService.buscarTodas(anyInt(), anyInt())).thenReturn(response);

        mockMvc.perform(get("/v1/produtos"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.content").isArray())
                .andExpect(jsonPath("$.content").isEmpty());
    }

    @Test
    void deveriaRetornarProdutoQuandoSolicitadoPorId() throws Exception {
        UUID produtoId = UUID.randomUUID();
        ProdutoResponse response = ProdutoResponse.builder()
                .uuid(produtoId)
                .nome("Produto Teste")
                .descricao("Descrição do produto teste")
                .categoria("Categoria teste")
                .preco(BigDecimal.valueOf(10.0))
                .imagemBase64("Imagem teste")
                .build();
        when(produtoService.buscarPorId(produtoId)).thenReturn(response);

        mockMvc.perform(get("/v1/produtos/{produtoId}", produtoId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.uuid").value(response.getUuid().toString()))
                .andExpect(jsonPath("$.nome").value(response.getNome()))
                .andExpect(jsonPath("$.descricao").value(response.getDescricao()))
                .andExpect(jsonPath("$.categoria").value(response.getCategoria()))
                .andExpect(jsonPath("$.preco").value(response.getPreco()))
                .andExpect(jsonPath("$.imagemBase64").value(response.getImagemBase64()));
    }

    @Test
    void deveriaSalvarProdutoQuandoSolicitado() throws Exception {
        ProdutoRequest request = ProdutoRequest.builder()
                .nome("Produto Teste")
                .descricao("Descrição do produto teste")
                .categoria("Categoria teste")
                .preco(BigDecimal.valueOf(10.0))
                .imagemBase64("Imagem teste")
                .build();
        ProdutoResponse response = ProdutoResponse.builder()
                .uuid(UUID.randomUUID())
                .nome("Produto Teste")
                .descricao("Descrição do produto teste")
                .categoria("Categoria teste")
                .preco(BigDecimal.valueOf(10.0))
                .imagemBase64("Imagem teste")
                .build();
        when(produtoService.salvar(any(ProdutoRequest.class))).thenReturn(response);

        mockMvc.perform(post("/v1/produtos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated()) // Alterado para isCreated()
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.uuid").value(response.getUuid().toString()))
                .andExpect(jsonPath("$.nome").value(response.getNome()))
                .andExpect(jsonPath("$.descricao").value(response.getDescricao()))
                .andExpect(jsonPath("$.categoria").value(response.getCategoria()))
                .andExpect(jsonPath("$.preco").value(response.getPreco()))
                .andExpect(jsonPath("$.imagemBase64").value(response.getImagemBase64()));
    }

    @Test
    void deveriaAtualizarProdutoQuandoSolicitado() throws Exception {
        ProdutoRequest request = ProdutoRequest.builder()
                .nome("Produto Teste")
                .descricao("Descrição do produto teste")
                .categoria("Categoria teste")
                .preco(BigDecimal.valueOf(10.0))
                .imagemBase64("Imagem teste")
                .build();
        ProdutoResponse response = ProdutoResponse.builder()
                .uuid(UUID.randomUUID())
                .nome("Produto Teste")
                .descricao("Descrição do produto teste")
                .categoria("Categoria teste")
                .preco(BigDecimal.valueOf(10.0))
                .imagemBase64("Imagem teste")
                .build();
        when(produtoService.atualizar(any(ProdutoRequest.class))).thenReturn(response);

        mockMvc.perform(patch("/v1/produtos/atualizar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.uuid").value(response.getUuid().toString()))
                .andExpect(jsonPath("$.nome").value(response.getNome()))
                .andExpect(jsonPath("$.descricao").value(response.getDescricao()))
                .andExpect(jsonPath("$.categoria").value(response.getCategoria()))
                .andExpect(jsonPath("$.preco").value(response.getPreco()))
                .andExpect(jsonPath("$.imagemBase64").value(response.getImagemBase64()));
    }

    @Test
    void deveriaExcluirProdutoQuandoSolicitado() throws Exception {
        UUID produtoId = UUID.randomUUID();

        mockMvc.perform(delete("/v1/produtos/{produtoId}", produtoId))
                .andExpect(status().isOk());
    }


}
