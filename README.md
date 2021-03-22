# Projeto Final de Linguagem de Programação II

### Projeto-Vendas

**Componentes:**

- Alexandre Dantas dos Santos

**Professor:**
	
- Vinícius Mendes

## Objetivo

O objetivo deste trabalho é implementar um programa de cadastro de venda, possibilitando o registro de compradores, vendedores e vendas.

## Tarefa

A tarefa central do projeto foi desenvolver um programa em Java para controlar um sistema de cadastro de vendas, possuindo a possibilidade de cadastro de compradores, vendedores e produtos.

## Operações suportadas

	1 - Cadastrar Comprador;
	2 - Consultar Compradores;
	3 - Listar Compradores;
	4 - Cadastrar Vendedor;
	5 - Consultar Vendedor;
	6 - Listar Vendedores;
    7 - Cadastrar Produto;
	8 - Consultar Produto;
	9 - Listar Produtos;
	10 - Cadastrar Venda;
	11 - Listar Vendas;

## Detalhes de desenvolvimento:

- Para cadastro de compradores temos as opções de cadastrar, consultar e listar compradores. No cadastro, não será permitido adicionar dois compradores com o mesmo CPF.
- Para cadastro de vendedores temos as opções de cadastrar, consultar e listar vendedores. No cadastro, não será permitido adicionar dois compradores com o mesmo CNPJ.
- Para cadastro de produtos temos as opções de cadastrar, consultar e listar produtos. No cadastro, não será permitido adicionar dois compradores com o mesmo código. Um produto deve também fazer parte do catálogo de um vendedor.
- Para cadastro da compra/venda, o sistema só permitirá o registro para compradores, vendedores e produtos cadastrados no sistema. Aĺém disso o sistema checará se o produto adicionado a compra pertence ao catálogo do vendedor selecionado. Opcionalmente também é possível selecionar outros produtos do catálogo do vendedor, durante a compra.

No registro do pagamento é possível realizar os seguintes tipos de pagamento: 

	1 - Pagamento por PIX;
	2 - Pagamento por Boleto;
	3 - Pagamento por Cartão de Crédito;
	4 - Pagamento por Cartão de Débito;

- Para pagamento por PIX, o comprador necessita ter fundos para realização da compra, neste ponto, haverá transferência de recursos do comprador para o vendedor.
- Para pagamento por Boleto, o comprador necessita ter fundos para realização da compra. Além disso, deverá ser informada também a data de vencimento do boleto, não podendo este boleto estar vencido para pagamento. Por fim, haverá transferência de recursos do comprador para a área de recursos a receber do vendedor, havendo também um desconto de 1 real pela geração do boleto.
- Para pagamento por Cartão de Crédito, não haverá necessidade do comprador ter fundos para pagamento. Neste ponto, haverá incremento dos registros de valores a pagar do comprador, e na área de valores a receber do vendedor, havendo também uma taxa de desconto 2% da operadora de cartão.
- Para pagamento por Débito, o comprador necessita ter fundos para realização da compra, neste ponto, haverá transferência de recursos do comprador para a area de recursos a receber do vendedor, havendo também uma taxa de desconto 2% da operadora de cartão.

OBS: Em todas as formas de pagamento, será considerada a data atual como data de pagamento.