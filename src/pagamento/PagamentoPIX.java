package pagamento;

import comprador.Comprador;
import vendedor.Vendedor;

public class PagamentoPIX extends FormaPagamento{	
	
	//Método que realiza o pagamento por PIX.
	public void realizarPagamento(Vendedor vendedor, Comprador comprador, double valorCompra) {

		if (checarFundos(comprador, valorCompra)) {

			comprador.debitaSaldoVendedor(valorCompra);
			comprador.incrementaComprasRealizadas();

			vendedor.incrementaSaldoVendedor(valorCompra);
			vendedor.incrementaVendasRealizadas();
			
			System.out.println("Pagamento realizado com sucesso.");
			System.out.println("");
		}

		else {

			System.out.println("O comprador não possui fundos para realização da compra.");
			System.out.println("");
		}

	}
	

}
