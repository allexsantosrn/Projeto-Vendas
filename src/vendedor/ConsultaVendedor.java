package vendedor;

import java.util.Collection;
import java.util.HashSet;

import produto.Produto;

public class ConsultaVendedor extends Vendedor {

	private Collection<Vendedor> vendedores = new HashSet<>();

	public void adicionarVendedor(Vendedor vendedor) {

		if (vendedores.contains(vendedor)) {
			System.out.println("");
			System.out.println("Já existe um vendedor com o cnpj informado na base de dados.");
		}

		else {
			vendedores.add(vendedor);
			System.out.println("");
			System.out.println("Vendedor cadastrado com sucesso.");
		}

	}

	// Retorna true caso o vendedor seja identificado na lista de vendedores.
	public boolean hasVendedor(String cnpj) {

		boolean existe = false;

		for (Vendedor vendedor : vendedores) {

			if (vendedor.getCnpj().equals(cnpj)) {
				existe = true;
			}
		}

		return existe;
	}

	public void consultarVendedor(String cnpj) {

		if (hasVendedor(cnpj)) {

			for (Vendedor vendedor : vendedores) {

				if (vendedor.getCnpj().equals(cnpj)) {
					System.out.println("");
					System.out.println(vendedor);
					System.out.println("");
					vendedor.getProdutosCatalogo();
					break;
				}
			}
		}

		else {
			System.out.println("");
			System.out.println("Não foram localizados vendedores com o CPF informado.");
		}

	}

	public void listarVendedores() {

		if (vendedores.isEmpty()) {
			System.out.println("");
			System.out.println("Não há registro de vendedores na base de dados.");
			System.out.println("");
		}

		else {

			int i = 1;
			System.out.println("");

			for (Vendedor vendedor : vendedores) {
				System.out.println("vendedor" + "[" + i + "] -" + " Nome: " + vendedor.getNome() + " - CNPJ: "
						+ vendedor.getCnpj());
				i++;
			}

			System.out.println("");

		}

	}

	public boolean listaVendedoresIsEmpty() {

		boolean vazio = false;

		if (vendedores.isEmpty()) {

			vazio = true;
		}

		return vazio;
	}

	public void adicionarItemCatalogo(String cnpj, Produto produto) {

		for (Vendedor vendedor : vendedores) {

			if (vendedor.getCnpj().equals(cnpj)) {
				vendedor.adicionarItemCatalogo(produto);
			}
		}
	}

	public Vendedor retornaVendedorByCNPJ(String cnpj) {

		Vendedor vendedorx = new Vendedor();

		for (Vendedor vendedor : vendedores) {

			if (vendedor.getCnpj().equals(cnpj)) {
				vendedorx = vendedor;
			}
		}

		return vendedorx;
	}
	
	public boolean hasProdutoCatalogo (Vendedor vendedor, int codigo) {
		
		boolean existe = false;

		if (vendedor.hasProdutoCatalogo(codigo)) {
			
			existe = true;
		}

		return existe;
	}

}
