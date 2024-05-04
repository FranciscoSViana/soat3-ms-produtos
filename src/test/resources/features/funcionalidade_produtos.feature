# language: pt
Funcionalidade: API - Produtos

  Cenário: Cadastro de produto
    Dado um produto é solicitado para cadastro
    Quando o endpoint de cadastro de produto é chamado
    Então o produto é cadastrado com sucesso