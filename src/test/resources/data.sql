INSERT INTO produto_model (id, categoria, imagem, nome, descricao, preco, data_hora_criacao, data_hora_alteracao, status)
VALUES (UUID_TO_BIN('01234567-89ab-cdef-0123-456789abcdef'), 'LANCHE', NULL, 'Produto Teste', 'Descrição do produto', 10.00, '2024-01-01 00:00:00', '2024-01-01 00:00:00', true);

INSERT INTO produto_model (id, categoria, imagem, nome, descricao, preco, data_hora_criacao, data_hora_alteracao, status)
VALUES (UUID_TO_BIN('12345678-90ab-cdef-0123-456789abcdef'), 'ACOMPANHAMENTO', NULL, 'Produto Acompanhamento', 'Descrição do acompanhamento', 5.0, '2024-01-02 00:00:00', '2024-01-02 00:00:00', true);

INSERT INTO produto_model (id, categoria, imagem, nome, descricao, preco, data_hora_criacao, data_hora_alteracao, status)
VALUES (UUID_TO_BIN('23456789-0abc-def0-1234-56789abcdef0'), 'BEBIDA', NULL, 'Produto Bebida', 'Descrição da bebida', 3.0, '2024-01-03 00:00:00', '2024-01-03 00:00:00', true);