package venda;

import java.util.Collection;
import java.util.HashSet;

public class ConsultaVenda extends Venda {

	private Collection<Venda> vendas = new HashSet<>();

	public void adicionarVenda(Venda venda) {

		vendas.add(venda);
	}

	public void listarVendas() {

		if (vendas.isEmpty()) {
			System.out.println("");
			System.out.println("Não há registro de vendedores na base de dados.");
			System.out.println("");
		}

		else {

			int i = 1;
			System.out.println("");

			for (Venda venda : vendas) {
				System.out.println("Venda" + "[" + i + "] -" + " Comprador: " + venda.getComprador().getNome()
						+ " - Vendedor: " + venda.getVendedor().getNome() + " - Tipo de Pagamento: "
						+ venda.getPagamento().getTipoPagamento() + " - Data de Pagamento: "
						+ venda.getPagamento().getDataPagamento() + " - Valor Total da Compra/Venda: "
						+ venda.getPagamento().getValorTotal());
				venda.getItensVenda();
				System.out.println("");

				i++;
			}

			System.out.println("");

		}

	}

	public boolean listaVendedoresIsEmpty() {

		boolean vazio = false;

		if (vendas.isEmpty()) {

			vazio = true;
		}

		return vazio;
	}

}
