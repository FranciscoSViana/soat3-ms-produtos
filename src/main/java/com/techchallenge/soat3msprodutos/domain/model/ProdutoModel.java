package com.techchallenge.soat3msprodutos.domain.model;


import com.techchallenge.soat3msprodutos.domain.enums.TipoCategoria;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;


@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "produto_model")
public class ProdutoModel {

    @Id
    private UUID id;

    @Enumerated(EnumType.STRING)
    private TipoCategoria categoria;

    @Lob
    private byte[] imagem;

    private String nome;

    private String descricao;

    private BigDecimal preco;

    @CreationTimestamp
    @JoinColumn(columnDefinition = "datetime")
    private LocalDateTime dataHoraCriacao;

    @UpdateTimestamp
    @JoinColumn(columnDefinition = "datetime")
    private LocalDateTime dataHoraAlteracao;

    private Boolean status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoModel that = (ProdutoModel) o;
        return Objects.equals(id, that.id) && categoria == that.categoria && Objects.deepEquals(imagem, that.imagem) && Objects.equals(nome, that.nome) && Objects.equals(descricao, that.descricao) && Objects.equals(preco, that.preco) && Objects.equals(dataHoraCriacao, that.dataHoraCriacao) && Objects.equals(dataHoraAlteracao, that.dataHoraAlteracao) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoria, Arrays.hashCode(imagem), nome, descricao, preco, dataHoraCriacao, dataHoraAlteracao, status);
    }
}
