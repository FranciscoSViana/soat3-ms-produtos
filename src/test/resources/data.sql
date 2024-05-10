DROP TABLE IF EXISTS produto_model;
CREATE TABLE produto_model (
                               id UUID PRIMARY KEY,
                               categoria VARCHAR(20),
                               data_hora_alteracao TIMESTAMP,
                               data_hora_criacao TIMESTAMP,
                               descricao VARCHAR(255),
                               imagem BLOB,
                               nome VARCHAR(255),
                               preco DECIMAL(38,2),
                               status BOOLEAN
);

INSERT INTO produto_model (id, categoria, imagem, nome, descricao, preco, data_hora_criacao, data_hora_alteracao, status)
VALUES ('01234567-89ab-cdef-0123-456789abcdef', 'LANCHE', NULL, 'Produto Teste', 'Descricao do produto', 10.00, '2024-01-01 00:00:00', '2024-01-01 00:00:00', true);

INSERT INTO produto_model (id, categoria, imagem, nome, descricao, preco, data_hora_criacao, data_hora_alteracao, status)
VALUES ('12345678-90ab-cdef-0123-456789abcdef', 'ACOMPANHAMENTO', NULL, 'Produto Acompanhamento', 'Descricao do acompanhamento', 5.0, '2024-01-02 00:00:00', '2024-01-02 00:00:00', true);

INSERT INTO produto_model (id, categoria, imagem, nome, descricao, preco, data_hora_criacao, data_hora_alteracao, status)
VALUES ('23456789-0abc-def0-1234-56789abcdef0', 'BEBIDA', NULL, 'Produto Bebida', 'Descricao da bebida', 3.0, '2024-01-03 00:00:00', '2024-01-03 00:00:00', true);