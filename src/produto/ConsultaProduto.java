package produto;

import java.util.Collection;
import java.util.HashSet;

public class ConsultaProduto extends Produto {

	private Collection<Produto> produtos = new HashSet<>();

	public void adicionarProduto(Produto produto) {

		if (produtos.contains(produto)) {
			System.out.println("");
			System.out.println("Já existe um produto com o código informado na base de dados.");
		}

		else {
			produtos.add(produto);
			System.out.println("");
			System.out.println("Produto cadastrado com sucesso.");
		}

	}

	// Retorna true caso o produto seja identificado na lista de produtos.
	public boolean hasProduto(int codigo) {

		boolean existe = false;

		for (Produto produto : produtos) {

			if (produto.getCodigo() == codigo) {
				existe = true;
			}
		}

		return existe;
	}

	public void consultarProduto(int codigo) {

		if (hasProduto(codigo)) {

			for (Produto produto : produtos) {

				if (produto.getCodigo() == codigo) {
					System.out.println("");
					System.out.println(produto);
					break;
				}
			}
		}

		else {
			System.out.println("");
			System.out.println("Não foram localizados produtos com o código informado.");
		}

	}

	public void listarProdutos() {

		if (produtos.isEmpty()) {
			System.out.println("");
			System.out.println("Não há registro de produtos na base de dados.");
			System.out.println("");
		}

		else {

			int i = 1;
			System.out.println("");

			for (Produto produto : produtos) {

				System.out.println("Produto" + "[" + i + "] -" + " Nome: " + produto.getNome() + " - Código: "
						+ produto.getCodigo());
				i++;
			}

			System.out.println("");

		}

	}

	public Produto retornaProdutoByCodigo(int codigo) {

		Produto produtox = new Produto();

		for (Produto produto : produtos) {

			if (produto.getCodigo() == codigo) {
				produtox = produto;
			}
		}

		return produtox;
	}

}
