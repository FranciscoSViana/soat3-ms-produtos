package com.techchallenge.soat3msprodutos.application.produto.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GlobalExceptionHandlerTest {

    @InjectMocks
    private GlobalExceptionHandler exceptionHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void handleProdutoNaoEncontradoException() {
        // Given
        ProdutoNaoEncontradoException ex = new ProdutoNaoEncontradoException("Produto não encontrado");

        // When
        ResponseEntity<String> responseEntity = exceptionHandler.handleClienteNaoEncontradoException(ex);

        // Then
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals("Produto não encontrado", responseEntity.getBody());
    }

    @Test
    void handleNegocioException() {
        // Given
        NegocioException ex = new NegocioException("Erro de negócio");

        // When
        ResponseEntity<String> responseEntity = exceptionHandler.handleClienteNegocioException(ex);

        // Then
        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, responseEntity.getStatusCode());
        assertEquals("Erro de negócio", responseEntity.getBody());
    }
}
