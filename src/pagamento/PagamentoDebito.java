package pagamento;

import comprador.Comprador;
import vendedor.Vendedor;

public class PagamentoDebito extends FormaPagamento {

	//Método que realiza o pagamento por débito.
	public void realizarPagamento(Vendedor vendedor, Comprador comprador, double valorCompra) {

		if (checarFundos(comprador, valorCompra)) {

			double creditoVendedor = valorCompra - (valorCompra * this.taxaOperadora);

			comprador.debitaSaldoVendedor(valorCompra);
			comprador.incrementaComprasRealizadas();

			vendedor.incrementaValoresaReceber(creditoVendedor);
			vendedor.incrementaVendasRealizadas();

			System.out.println("Pagamento realizado com sucesso.");
			System.out.println("");

		} else {

			System.out.println("O comprador não possui fundos para realização da compra.");
			System.out.println("");
		}

	}
}
