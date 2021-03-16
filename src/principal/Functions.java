package principal;

import java.util.Scanner;

import comprador.Comprador;
import comprador.ConsultaComprador;
import pagamento.FormaPagamento;
import produto.ConsultaProduto;
import produto.Produto;
import venda.Venda;
import vendedor.ConsultaVendedor;
import vendedor.Vendedor;

public class Functions {

	Scanner input = new Scanner(System.in);

	ConsultaComprador action = new ConsultaComprador();

	ConsultaVendedor action2 = new ConsultaVendedor();

	ConsultaProduto action3 = new ConsultaProduto();

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

	public void consultarComprador() {

		System.out.print("Informe o cpf do comprador: ");
		String cpf = input.next();
		action.consultarComprador(cpf);
	}

	public void listarCompradores() {

		action.listarCompradores();
	}

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

	public void consultarVendedor() {

		System.out.print("Informe o cnpj do vendedor: ");
		String cnpj = input.next();
		action2.consultarVendedor(cnpj);
	}

	public void listarVendedores() {

		action2.listarVendedores();
	}

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

	public void consultarProduto() {

		System.out.print("Informe o código do comprador: ");
		int codigo = input.nextInt();
		action3.consultarProduto(codigo);
	}

	public void listarProdutos() {

		action3.listarProdutos();
	}
	
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
		else {
			
			venda.adicionarItemVenda(action3.retornaProdutoByCodigo(codigo));				
			System.out.printf("Produto de código: %d adicionado com sucesso: \n",codigo);
			
			System.out.print("Deseja adicionar mais um produto a compra? (1-Sim / 2-Não): ");
			option = input.nextInt();
			
			while (option == 1) {
								
				System.out.print("Informe o código do produto: ");
				codigo = input.nextInt();
				
				if (action3.hasProduto(codigo)) {
					venda.adicionarItemVenda(action3.retornaProdutoByCodigo(codigo));
					System.out.printf("Produto de código: %d adicionado com sucesso: \n",codigo);
				}
				
				else {
					System.out.println("Não foram localizados produtos com o código informado.");					
				}
				
				System.out.print("Deseja adicionar mais um produto a compra? (1-Sim / 2-Não): ");
				option = input.nextInt();
			}
			
			double valorCompra = venda.getValorProdutos();
			
			System.out.printf("Total a pagar: %2f \n",valorCompra);
			
			FormaPagamento pagamento = new FormaPagamento();
			
			System.out.println("Informe a opção de pagamento: ");
			
			while (option != 1 || option !=2 || option !=3 || option !=4) {
				
				System.out.println("1 - Pagamento por PIX.");
				System.out.println("2 - Pagamento por Boleto.");
				System.out.println("3 - Pagamento por Cartão de Crédito.");
				System.out.println("4 - Pagamento por Cartão de Débito.");
				System.out.println("Opção desejada: ");
				option = input.nextInt();
				
				if((option != 1 || option !=2 || option !=3 || option !=4)) {
					
					System.out.println("Opção inválida. Informe a opção de pagamento: ");					
				}
				
				else {		
					
					System.out.println("Informe a data de pagamento do boleto: ");
					String dataPagamento = input.next();
					
					System.out.println("Informe a data de vencimento do boleto: ");
					String dataVencimento = input.next();
					
					if (option == 1) {
					
					pagamento.realizarPagamentobyPIX(valorCompra);
					
				}
			}
			
			}
			
		
			
			
		}
	}
	
}