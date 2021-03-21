package comprador;

import java.util.Collection;
import java.util.HashSet;

import venda.Venda;

public class ConsultaComprador extends Comprador {

	private Collection<Comprador> compradores = new HashSet<>();

	public void adicionarComprador(Comprador comprador) {

		if (compradores.contains(comprador)) {
			System.out.println("");
			System.out.println("Já existe um comprador com o código informado na base de dados.");
			System.out.println("");
		}

		else {
			compradores.add(comprador);
			System.out.println("");
			System.out.println("Comprador cadastrado com sucesso.");
			System.out.println("");
		}

	}

	// Retorna true caso o comprador seja identificado na lista de compradores.
	public boolean hasComprador(String cpf) {

		boolean existe = false;

		for (Comprador comprador : compradores) {

			if (comprador.getCpf().equals(cpf)) {
				existe = true;
			}
		}

		return existe;
	}

	public void consultarComprador(String cpf) {

		if (hasComprador(cpf)) {

			for (Comprador comprador : compradores) {

				if (comprador.getCpf().equals(cpf)) {
					System.out.println("");
					System.out.println(comprador);
					comprador.getCompra();
					break;
				}
			}
		}

		else {
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

				System.out.println("Comprador" + "[" + i + "] -" + " CPF: " + comprador.getCpf() + " - Nome: "
						+ comprador.getNome());
				i++;
			}

			System.out.println("");

		}

	}

	public Comprador retornaCompradorByCPF(String cpf) {

		Comprador compradorx = new Comprador();

		for (Comprador comprador : compradores) {

			if (comprador.getCpf().equals(cpf)) {
				compradorx = comprador;
			}
		}

		return compradorx;
	}

	public void adicionarCompra(Comprador comprador, Venda venda) {

		comprador.adicionarCompra(venda);
	}

}
