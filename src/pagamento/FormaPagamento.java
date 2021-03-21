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
	private Date dataPagamento;

	protected final double taxaOperadora = 0.02;
	protected final double valorEmissaoBoleto = 1.00;

	protected static final DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

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

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(String dataPagamento) throws ParseException {
		this.dataPagamento = formatador.parse(dataPagamento);
	}

	public void realizarPagamento() {

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

	protected Date convertStringtoDate(String data) throws ParseException {

		Date dataConvertida;

		dataConvertida = formatador.parse(data);

		return dataConvertida;

	}

}
