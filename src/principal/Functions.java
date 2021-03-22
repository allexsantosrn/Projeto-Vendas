package principal;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import comprador.Comprador;
import comprador.ConsultaComprador;
import pagamento.PagamentoBoleto;
import pagamento.PagamentoCredito;
import pagamento.PagamentoDebito;
import pagamento.PagamentoPIX;
import produto.ConsultaProduto;
import produto.Produto;
import venda.ConsultaVenda;
import venda.Venda;
import vendedor.ConsultaVendedor;
import vendedor.Vendedor;

public class Functions {

	Scanner input = new Scanner(System.in);

	ConsultaComprador action = new ConsultaComprador();

	ConsultaVendedor action2 = new ConsultaVendedor();

	ConsultaProduto action3 = new ConsultaProduto();
	
	ConsultaVenda action4 = new ConsultaVenda();	

	//Invoca o método para cadastro do comprador.
	public void cadastrarComprador() {

		Comprador comprador = new Comprador();

		System.out.print("Informe o CPF do comprador: ");
		String cpf = input.next();
		input.nextLine();

		System.out.print("Informe o nome do comprador: ");
		String nome = input.nextLine();

		System.out.print("Informe o saldo inicial do comprador: ");
		double saldo = input.nextDouble();

		comprador.setCpf(cpf);
		comprador.setNome(nome);
		comprador.setSaldo(saldo);

		action.adicionarComprador(comprador);
	}
	
	//Invoca o método para consulta do comprador.
	public void consultarComprador() {

		System.out.print("Informe o cpf do comprador: ");
		String cpf = input.next();
		action.consultarComprador(cpf);
	}

	//Invoca o método para listagem dos compradores.
	public void listarCompradores() {

		action.listarCompradores();
	}
	
	//Invoca o método para cadastro do vendedor.
	public void cadastrarVendedor() {

		Vendedor vendedor = new Vendedor();

		System.out.print("Informe o CNPJ do vendedor: ");
		String cnpj = input.next();
		input.nextLine();

		System.out.print("Informe o nome do vendedor: ");
		String nome = input.nextLine();

		System.out.print("Informe o saldo inicial do vendedor: ");
		double saldo = input.nextDouble();

		vendedor.setCnpj(cnpj);
		vendedor.setNome(nome);
		vendedor.setSaldo(saldo);

		action2.adicionarVendedor(vendedor);
	}
	
	//Invoca o método para consulta do vendedor.
	public void consultarVendedor() {

		System.out.print("Informe o cnpj do vendedor: ");
		String cnpj = input.next();
		action2.consultarVendedor(cnpj);
	}
	
	//Invoca o método para listagem dos vendedores.
	public void listarVendedores() {

		action2.listarVendedores();
	}
	
	//Invoca o método para cadastro do produto.
	public void cadastrarProduto() {

		Produto produto = new Produto();

		System.out.print("Informe o código do produto: ");
		int codigo = input.nextInt();
		input.nextLine();

		System.out.print("Informe o nome do produto: ");
		String nome = input.nextLine();

		System.out.print("Informe o preço unitário do produto: ");
		double saldo = input.nextDouble();

		System.out.print("Informe o catálogo do produto (Inserir o cnpj do vendedor): ");
		String cnpj = input.next();

		if (action3.hasProduto(codigo)) {

			System.out.println("");
			System.out.println("Já existe um produto com o código informado na base de dados.");
		}

		else if (action2.listaVendedoresIsEmpty()) {

			System.out.println("");
			System.out.println("Não há vendedores cadastrados na base de dados.");
		}

		else if (action2.hasVendedor(cnpj)) {

			produto.setCodigo(codigo);
			produto.setNome(nome);
			produto.setPrecoUnitario(saldo);

			action3.adicionarProduto(produto);

			action2.adicionarItemCatalogo(cnpj, produto);
		}

		else {

			System.out.println("");
			System.out.println("Não foram localizados vendedores com o CNPJ informado.");
		}

	}
	
	//Invoca o método para consulta do produto.
	public void consultarProduto() {

		System.out.print("Informe o código do comprador: ");
		int codigo = input.nextInt();
		action3.consultarProduto(codigo);
	}
	
	//Invoca o método para listagem de produtos.
	public void listarProdutos() {

		action3.listarProdutos();
	}
	
	//Invoca o método para listagem das vendas.
	public void listarVendas() {
		
		action4.listarVendas();
	}

	//Invoca o método para cadastro da venda.
	public void cadastrarVenda() {

		Venda venda = new Venda();

		int option = 0;

		System.out.print("Informe o CPF do comprador: ");
		String cpf = input.next();

		System.out.print("Informe o CNPJ do vendedor: ");
		String cnpj = input.next();

		System.out.print("Informe o código do produto: ");
		int codigo = input.nextInt();

		if (!action.hasComprador(cpf)) {
			System.out.println("Não foram localizados compradores com o CPF informado.");
		}

		else if (!action2.hasVendedor(cnpj)) {
			System.out.println("Não foram localizados vendedores com o CNPJ informado.");
		}

		else if (!action3.hasProduto(codigo)) {
			System.out.println("Não foram localizados produtos com o código informado.");
		}

		else if (!action2.hasProdutoCatalogo(action2.retornaVendedorByCNPJ(cnpj), codigo)) {
			System.out.println(
					"Não foram localizados produtos com o código informado no catálogo do vendedor selecionado.");
		}

		else {

			System.out.print("Informe a quantidade de itens do produto selecionado: ");
			int quantidade = input.nextInt();

			double valorCompra = 0.0;
			valorCompra = valorCompra + action3.retornaProdutoByCodigo(codigo).getPrecoUnitario() * quantidade;

			venda.adicionarItemVenda(action3.retornaProdutoByCodigo(codigo));
			System.out.printf("Produto de código: %d adicionado com sucesso. \n", codigo);

			System.out.print("Deseja adicionar mais um produto a compra? (1 - Sim / Outra Opção - Não): ");
			option = input.nextInt();

			while (option == 1) {

				System.out.print("Informe o código do produto: ");
				codigo = input.nextInt();

				if (action2.hasProdutoCatalogo(action2.retornaVendedorByCNPJ(cnpj), codigo)) {

					if (!venda.hasItemVenda(action3.retornaProdutoByCodigo(codigo))) {
						System.out.print("Informe a quantidade de itens do produto selecionado: ");
						quantidade = input.nextInt();

						valorCompra = valorCompra
								+ action3.retornaProdutoByCodigo(codigo).getPrecoUnitario() * quantidade;

						venda.adicionarItemVenda(action3.retornaProdutoByCodigo(codigo));
						System.out.printf("Produto de código: %d adicionado com sucesso. \n", codigo);
					}

				}

				else {
					System.out.println(
							"Não foram localizados produtos com o código informado no catálogo do vendedor selecionado.");
				}

				System.out.print("Deseja adicionar mais um produto a compra? (1 - Sim / Outra Opção - Não): ");
				option = input.nextInt();
			}

			System.out.printf("Total a pagar: %.2f \n", valorCompra);

			System.out.println("Informe a opção de pagamento: ");
			option = 5;

			while (option != 1 && option != 2 && option != 3 && option != 4) {

				System.out.println("1 - Pagamento por PIX.");
				System.out.println("2 - Pagamento por Boleto.");
				System.out.println("3 - Pagamento por Cartão de Crédito.");
				System.out.println("4 - Pagamento por Cartão de Débito.");
				System.out.print("Opção desejada: ");
				option = input.nextInt();

				if ((option != 1 && option != 2 && option != 3 && option != 4)) {

					System.out.println("Opção inválida. Informe a opção de pagamento: ");
				}

				else {

					LocalDateTime agora = LocalDateTime.now();
					DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
					String dataPagamento = formatterData.format(agora);

					if (option == 1) {

						System.out.println("Você escolheu a opção de pagamento: PIX.");

						PagamentoPIX pagamentoPIX = new PagamentoPIX();

						if (pagamentoPIX.checarFundos(action.retornaCompradorByCPF(cpf), valorCompra)) {

							pagamentoPIX.realizarPagamento(action2.retornaVendedorByCNPJ(cnpj),
									action.retornaCompradorByCPF(cpf), valorCompra);

							try {
								pagamentoPIX.setDataPagamento(dataPagamento);
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							pagamentoPIX.setValorTotal(valorCompra);
							pagamentoPIX.setTipoPagamento("PIX");
							venda.setVendedor(action2.retornaVendedorByCNPJ(cnpj));
							venda.setComprador(action.retornaCompradorByCPF(cpf));
							venda.setPagamento(pagamentoPIX);
							action.adicionarCompra(action.retornaCompradorByCPF(cpf), venda);
							action2.adicionarVenda(action2.retornaVendedorByCNPJ(cnpj), venda);
							action4.adicionarVenda(venda);
						}
						
						else {
							
							System.out.println("O comprador não possui fundos para realização da compra.");
							System.out.println("");
						}

					}

					else if (option == 2) {

						System.out.println("Você escolheu a opção de pagamento: BOLETO BANCÁRIO.");

						System.out.print("Informe a data de vencimento do boleto: ");
						String dataVencimento = input.next();

						PagamentoBoleto pagamentoBoleto = new PagamentoBoleto();

						if (pagamentoBoleto.checarFundos(action.retornaCompradorByCPF(cpf), valorCompra)) {

							pagamentoBoleto.realizarPagamento(action2.retornaVendedorByCNPJ(cnpj),
									action.retornaCompradorByCPF(cpf), valorCompra, dataVencimento, dataPagamento);

							try {
								pagamentoBoleto.setDataVencimento(dataVencimento);
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							try {
								pagamentoBoleto.setDataPagamento(dataPagamento);
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							pagamentoBoleto.setValorTotal(valorCompra);
							pagamentoBoleto.setTipoPagamento("BOLETO");
							venda.setVendedor(action2.retornaVendedorByCNPJ(cnpj));
							venda.setComprador(action.retornaCompradorByCPF(cpf));
							venda.setPagamento(pagamentoBoleto);
							action.adicionarCompra(action.retornaCompradorByCPF(cpf), venda);
							action2.adicionarVenda(action2.retornaVendedorByCNPJ(cnpj), venda);
							action4.adicionarVenda(venda);
						}
						
						else {
							
							System.out.println("O comprador não possui fundos para realização da compra.");
							System.out.println("");
						}

					}

					else if (option == 3) {

						System.out.println("Você escolheu a opção de pagamento: PAGAMENTO POR CARTÃO DE CRÉDITO.");

						PagamentoCredito pagamentoCredito = new PagamentoCredito();
						
							pagamentoCredito.realizarPagamento(action2.retornaVendedorByCNPJ(cnpj),
									action.retornaCompradorByCPF(cpf), valorCompra);

							try {
								pagamentoCredito.setDataPagamento(dataPagamento);
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							pagamentoCredito.setValorTotal(valorCompra);
							pagamentoCredito.setTipoPagamento("CREDITO");
							venda.setVendedor(action2.retornaVendedorByCNPJ(cnpj));
							venda.setComprador(action.retornaCompradorByCPF(cpf));
							venda.setPagamento(pagamentoCredito);
							action.adicionarCompra(action.retornaCompradorByCPF(cpf), venda);
							action2.adicionarVenda(action2.retornaVendedorByCNPJ(cnpj), venda);
							action4.adicionarVenda(venda);				

					}

					else {

						System.out.println("Você escolheu a opção de pagamento: PAGAMENTO POR CARTÃO DE DÉBITO.");

						PagamentoDebito pagamentoDebito = new PagamentoDebito();

						if (pagamentoDebito.checarFundos(action.retornaCompradorByCPF(cpf), valorCompra)) {

							pagamentoDebito.realizarPagamento(action2.retornaVendedorByCNPJ(cnpj),
									action.retornaCompradorByCPF(cpf), valorCompra);

							try {
								pagamentoDebito.setDataPagamento(dataPagamento);
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							pagamentoDebito.setValorTotal(valorCompra);
							pagamentoDebito.setTipoPagamento("DEBITO");
							venda.setVendedor(action2.retornaVendedorByCNPJ(cnpj));
							venda.setComprador(action.retornaCompradorByCPF(cpf));
							venda.setPagamento(pagamentoDebito);
							action.adicionarCompra(action.retornaCompradorByCPF(cpf), venda);
							action2.adicionarVenda(action2.retornaVendedorByCNPJ(cnpj), venda);
							action4.adicionarVenda(venda);
						}
						
						else {
							
							System.out.println("O comprador não possui fundos para realização da compra.");
							System.out.println("");
						}
					}

				}
			}

		}
	}

}