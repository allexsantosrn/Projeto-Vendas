package pagamento;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import comprador.Comprador;
import vendedor.Vendedor;

public class FormaPagamento {

	private double valorTotal;
	private String tipoPagamento;
	private Date dataVencimento;
	private Date dataPagamento;

	private final double taxaOperadora = 0.02;
	private final double valorEmissaoBoleto = 1.00;

	private static final DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

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

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(String dataVencimento) throws ParseException {
		this.dataVencimento = formatador.parse(dataVencimento);
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(String dataPagamento) throws ParseException {
		this.dataPagamento = formatador.parse(dataPagamento);
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

	public void realizarPagamentobyBoleto(Vendedor vendedor, Comprador comprador, double valorCompra,
			String dataVencimento, String dataPagamento) {

		Date dataVencimentoConvertida = null;
		try {
			dataVencimentoConvertida = convertStringtoDate(dataVencimento);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date dataPagamentoConvertida = null;
		try {
			dataPagamentoConvertida = convertStringtoDate(dataPagamento);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (!checarFundos(vendedor, comprador, valorCompra)) {

			System.out.println("O comprador não possui fundos para realização da compra.");
		}

		else if (!verificavencimento(dataVencimentoConvertida, dataPagamentoConvertida)) {

			System.out.println(
					"Boleto vencido. Não é permitido realizar pagamentos após a data de vencimento do boleto.");
		}

		else {

			double creditoVendedor = valorCompra - valorEmissaoBoleto;
			comprador.debitaSaldoVendedor(valorCompra);
			comprador.incrementaComprasRealizadas();

			vendedor.incrementaValoresaReceber(creditoVendedor);
			vendedor.incrementaVendasRealizadas();

			System.out.println("Pagamento realizado com sucesso.");

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

		} else {

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

	public boolean verificavencimento(Date dataVencimento, Date dataPagamento) {

		boolean data = true;

		if (dataPagamento.after(dataVencimento)) {

			data = false;
		}

		return data;

	}

	private Date convertStringtoDate(String data) throws ParseException {

		Date dataConvertida;

		dataConvertida = formatador.parse(data);

		return dataConvertida;

	}

}
