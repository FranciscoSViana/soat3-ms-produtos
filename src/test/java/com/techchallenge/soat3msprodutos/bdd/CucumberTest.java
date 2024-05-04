package com.techchallenge.soat3msprodutos.bdd;

import com.techchallenge.soat3msprodutos.adapter.produto.ProdutoController;
import com.techchallenge.soat3msprodutos.adapter.produto.model.ProdutoRequest;
import com.techchallenge.soat3msprodutos.adapter.produto.model.ProdutoResponse;
import com.techchallenge.soat3msprodutos.application.produto.service.ProdutoService;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
public class CucumberTest {

    @InjectMocks
    private ProdutoController produtoController;

    @Mock
    private ProdutoService produtoService;

    private ProdutoRequest produtoRequest;
    private ProdutoResponse produtoResponse;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Dado("um produto é solicitado para cadastro")
    public void umProdutoESolicitadoParaCadastro() {
        produtoRequest = new ProdutoRequest();

    }

    @Quando("o endpoint de cadastro de produto é chamado")
    public void oEndpointDeCadastroDeProdutoEChamado() {
        produtoResponse = new ProdutoResponse();
        when(produtoService.salvar(any(ProdutoRequest.class))).thenReturn(produtoResponse);
    }

    @Então("o produto é cadastrado com sucesso")
    public void oProdutoECadastradoComSucesso() {
        ResponseEntity<ProdutoResponse> responseEntity = produtoController.cadastrarProduto(produtoRequest);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(produtoResponse, responseEntity.getBody());
    }
}
