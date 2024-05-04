package com.techchallenge.soat3msprodutos.infrastruture.produto.repository;

import com.techchallenge.soat3msprodutos.domain.model.ProdutoModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Sql(scripts = "/data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class ProdutoRepositoryIT {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Test
    public void testFindByStatusTrue() {
        List<ProdutoModel> produtos = produtoRepository.findByStatusTrue(PageRequest.of(0, 10));
        assertNotNull(produtos);
        assertFalse(produtos.isEmpty());
    }

    @Test
    public void testFindById() {
        UUID produtoId = UUID.fromString("01234567-89ab-cdef-0123-456789abcdef");
        Optional<ProdutoModel> produtoOptional = produtoRepository.findById(produtoId);
        assertTrue(produtoOptional.isPresent());

        ProdutoModel produto = produtoOptional.get();
        assertEquals(produtoId, produto.getId());
        assertEquals("Produto Teste", produto.getNome());
        assertEquals(BigDecimal.valueOf(10.0).setScale(2), produto.getPreco());
    }


}
