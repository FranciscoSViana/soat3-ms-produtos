package com.techchallenge.soat3msprodutos.domain.model;


import com.techchallenge.soat3msprodutos.domain.enums.TipoCategoria;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
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
}
