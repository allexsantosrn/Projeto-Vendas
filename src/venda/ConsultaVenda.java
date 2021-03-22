package venda;

import java.util.Collection;
import java.util.HashSet;

public class ConsultaVenda extends Venda {

	private Collection<Venda> vendas = new HashSet<>();

	//Adiciona uma venda a coleção de vendas.
	public void adicionarVenda(Venda venda) {

		vendas.add(venda);
	}

	//Realiza a listagem de vendas.
	public void listarVendas() {

		if (vendas.isEmpty()) {
			System.out.println("");
			System.out.println("Não há registro de vendas na base de dados.");
			System.out.println("");
		}

		else {

			int i = 1;
			System.out.println("");
			System.out.println("Registros de vendas: ");

			for (Venda venda : vendas) {
				System.out.println("Venda" + "[" + i + "] -" + " Comprador: " + venda.getComprador().getNome()
						+ " - Vendedor: " + venda.getVendedor().getNome() + " - Tipo de Pagamento: "
						+ venda.getPagamento().getTipoPagamento() + " - Data de Pagamento: "
						+ venda.getPagamento().getDataPagamento() + " - Valor Total da Compra/Venda: "
						+ venda.getPagamento().getValorTotal());
				venda.getItensVenda();
				i++;
			}

			System.out.println("");

		}

	}
	
	//Returna true caso a lista de vendedores seja vazia.
	public boolean listaVendedoresIsEmpty() {

		boolean vazio = false;

		if (vendas.isEmpty()) {

			vazio = true;
		}

		return vazio;
	}

}
