package pagamento;

import comprador.Comprador;
import vendedor.Vendedor;

public class FormaPagamento {

	private double valorTotal;
	private String tipoPagamento;
	private String dataVencimento;
	private String dataPagamento;

	private final double taxaOperadora = 0.02;

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public String getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public String getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(String dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public void realizarPagamentobyPIX(Vendedor vendedor, Comprador comprador, double valorCompra) {

		if (checarFundos(vendedor, comprador, valorCompra)) {

			comprador.debitaSaldoVendedor(valorCompra);
			comprador.incrementaComprasRealizadas();

			vendedor.incrementaSaldoVendedor(valorCompra);
			vendedor.incrementaVendasRealizadas();

			System.out.println("Pagamento realizado com sucesso.");
		}

		else {

			System.out.println("O comprador não possui fundos para realização da compra.");
		}

	}

	public void realizarPagamentobyBoleto(Vendedor vendedor, Comprador comprador, double valorCompra) {

		if (checarFundos(vendedor, comprador, valorCompra)) {

			comprador.debitaSaldoVendedor(valorCompra);
			comprador.incrementaComprasRealizadas();

			vendedor.incrementaValoresaReceber(valorCompra);
			vendedor.incrementaVendasRealizadas();

			System.out.println("Pagamento realizado com sucesso.");
		}

		else {

			System.out.println("O comprador não possui fundos para realização da compra.");
		}

	}

	public void realizarPagamentobyDebito(Vendedor vendedor, Comprador comprador, double valorCompra) {

		if (checarFundos(vendedor, comprador, valorCompra)) {

			double creditoVendedor = valorCompra - (valorCompra * this.taxaOperadora);

			comprador.debitaSaldoVendedor(valorCompra);
			comprador.incrementaComprasRealizadas();

			vendedor.incrementaValoresaReceber(creditoVendedor);
			vendedor.incrementaVendasRealizadas();

			System.out.println("Pagamento realizado com sucesso.");
		}

		else {

			System.out.println("O comprador não possui fundos para realização da compra.");
		}

	}

	public void realizarPagamentobyCredito(Vendedor vendedor, Comprador comprador, double valorCompra) {

		double creditoVendedor = valorCompra - (valorCompra * this.taxaOperadora);

		comprador.incrementaValoresaPagar(valorCompra);
		comprador.incrementaComprasRealizadas();

		vendedor.incrementaValoresaReceber(creditoVendedor);
		vendedor.incrementaVendasRealizadas();

		System.out.println("Pagamento realizado com sucesso.");
	}

	public boolean checarFundos(Vendedor vendedor, Comprador comprador, double valorCompra) {

		boolean hasFundos = false;

		if (valorCompra <= vendedor.getSaldo()) {

			hasFundos = true;
		}

		return hasFundos;
	}

}
