package com.techchallenge.soat3msprodutos.infrastruture.produto.repository;

import com.techchallenge.soat3msprodutos.domain.model.ProdutoModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, UUID> {

    List<ProdutoModel> findByStatusTrue(Pageable pageable);
}
