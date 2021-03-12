package principal;

import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;

import comprador.Comprador;
import produto.Produto;
import vendedor.Vendedor;

public class Menu {

	Scanner in = new Scanner(System.in);

	private Collection<Comprador> compradores = new HashSet<>();
	private Collection<Vendedor> vendedores = new HashSet<>();
	private Collection<Produto> produtos = new HashSet<>();

	private void adicionarComprador(Comprador comprador) {

		if (compradores.contains(comprador)) {
			System.out.println("");
			System.out.println("O comprador informado já se encontra cadastrado na base de dados.");
			System.out.println("");
		}

		else {
			compradores.add(comprador);
			System.out.println("");
			System.out.println("Comprador cadastrado com sucesso.");
			System.out.println("");
		}

	}

	private void adicionarVendedor(Vendedor vendedor) {

		if (vendedores.contains(vendedor)) {
			System.out.println("");
			System.out.println("O vendedor informado já se encontra cadastrado na base de dados.");
			System.out.println("");
		}

		else {
			vendedores.add(vendedor);
			System.out.println("");
			System.out.println("Vendedor cadastrado com sucesso.");
			System.out.println("");
		}

	}

	private void adicionarProduto(Produto produto) {

		if (produtos.contains(produto)) {
			System.out.println("");
			System.out.println("O produto informado já se encontra cadastrado na base de dados.");
			System.out.println("");
		}

		else {
			produtos.add(produto);
			System.out.println("");
			System.out.println("Produto cadastrado com sucesso.");
			System.out.println("");
		}

	}

	private boolean hasComprador(String cpf) {

		boolean existe = false;

		for (Comprador comprador : compradores) {

			if (comprador.getCpf().equals(cpf)) {
				System.out.println("");
				System.out.println(comprador);
				System.out.println("");
				existe = true;
				break;
			}
		}

		return existe;

	}

	private boolean hasVendedor(String cnpj) {

		boolean existe = false;

		for (Vendedor vendedor : vendedores) {

			if (vendedor.getCnpj().equals(cnpj)) {
				System.out.println("");
				System.out.println(vendedor);
				vendedor.retornarCatalogoVendedor(vendedor);				
				System.out.println("");
				existe = true;
				break;
			}
		}

		return existe;

	}
	
	private boolean hasProduto(int codigo) {

		boolean existe = false;

		for (Produto produto : produtos) {

			if (produto.getCodigo() == codigo) {
				System.out.println("");
				System.out.println(produto);
				System.out.println("");
				existe = true;
				break;
			}
		}

		return existe;

	}

	public void cadastrarComprador() {

		Comprador comprador = new Comprador();

		System.out.print("Informe o CPF do comprador: ");
		String cpf = in.next();
		in.nextLine();

		System.out.print("Informe o nome do comprador: ");
		String nome = in.nextLine();

		System.out.print("Informe o saldo inicial do comprador: ");
		double saldo = in.nextDouble();

		comprador.setCpf(cpf);
		comprador.setNome(nome);
		comprador.setSaldo(saldo);

		adicionarComprador(comprador);
	}

	public void consultarComprador() {

		System.out.print("Informe o cpf do comprador: ");
		String cpf = in.next();

		if (!hasComprador(cpf)) {
			System.out.println("");
			System.out.println("Não foram localizados compradores com o CPF informado.");
			System.out.println("");
		}

	}

	public void listarCompradores() {

		if (compradores.isEmpty()) {
			System.out.println("");
			System.out.println("Não há registro de compradores na base de dados.");
			System.out.println("");
		}

		else {

			int i = 1;
			System.out.println("");

			for (Comprador comprador : compradores) {
				System.out.println(
						"Comprador" + "[" + i + "] -" + " Nome: " + comprador.getNome() + " - CPF: " + comprador.getCpf());
				i++;
			}

			System.out.println("");

		}

	}

	public void cadastrarVendedor() {

		Vendedor vendedor = new Vendedor();

		System.out.print("Informe o CNPJ do vendedor: ");
		String cnpj = in.next();
		in.nextLine();

		System.out.print("Informe o nome do vendedor: ");
		String nome = in.nextLine();

		System.out.print("Informe o saldo inicial do vendedor: ");
		double saldo = in.nextDouble();

		vendedor.setCnpj(cnpj);
		vendedor.setNome(nome);
		vendedor.setSaldo(saldo);

		adicionarVendedor(vendedor);
	}

	public void consultarVendedor() {

		System.out.print("Informe o cnpj do vendedor: ");
		String cnpj = in.next();
		
		if (!hasVendedor(cnpj)) {
			System.out.println("");
			System.out.println("Não foram localizados compradores com o CPF informado.");
			System.out.println("");
		}

	}

	public void listarVendedores() {

		int i = 1;
		System.out.println("");

		for (Vendedor vendedor : vendedores) {
			System.out.println(
					"Vendedor" + "[" + i + "] -" + " Nome: " + vendedor.getNome() + " - CNPJ: " + vendedor.getCnpj());
			i++;
		}

		System.out.println("");
	}
	
	public void cadastrarProduto() {

		Produto produto = new Produto();

		System.out.print("Informe o código do produto: ");
		int codigo = in.nextInt();
		in.nextLine();

		System.out.print("Informe o nome do produto: ");
		String nome = in.nextLine();

		System.out.print("Informe o preço unitário do produto: ");
		double saldo = in.nextDouble();

		System.out.print("Informe o catálogo do produto (Inserir o cnpj do vendedor): ");
		String cnpj = in.next();

		if (vendedores.isEmpty()) {
			System.out.println("");
			System.out.println("Não foram localizados vendedores com o CNPJ informado.");
			System.out.println("");
		}

		else {
						
			for (Vendedor vendedor : vendedores) {

				if (vendedor.getCnpj().equals(cnpj)) {
					produto.setCodigo(codigo);
					produto.setNome(nome);
					produto.setPrecoUnitario(saldo);

					vendedor.adicionarItemCatalogo(vendedor, produto);
					adicionarProduto(produto);
				}

				else {
					System.out.println("");
					System.out.println("Não foram localizados vendedores com o CNPJ informado.");
					System.out.println("");
				}

			}
		}

	}
	/*
	public void cadastrarProduto() {

		Produto produto = new Produto();
		Vendedor vendedor = new Vendedor();
		
		System.out.print("Informe o código do produto: ");
		int codigo = in.nextInt();
		in.nextLine();

		System.out.print("Informe o nome do produto: ");
		String nome = in.nextLine();

		System.out.print("Informe o preço unitário do produto: ");
		double preco = in.nextDouble();
		
		produto.setCodigo(codigo);
		produto.setNome(nome);
		produto.setPrecoUnitario(preco);
		
		vendedor.adicionarItemCatalogo(produto);		
		
	}*/
		
	public void consultarProduto() {

		System.out.print("Informe o código do produto: ");
		int codigo = in.nextInt();

		if (!hasProduto(codigo)) {
			System.out.println("");
			System.out.println("Não foram localizados produtos com o código informado.");
			System.out.println("");
		}

	}

}
