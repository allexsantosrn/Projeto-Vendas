package pagamento;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import comprador.Comprador;

public class FormaPagamento {

	private double valorTotal;
	private String tipoPagamento;
	private Date dataPagamento;

	protected final double taxaOperadora = 0.02; //Taxa da operadora de cartão: 2% de Juros
	protected final double valorEmissaoBoleto = 1.00; //Taxa de emissão do boleto: R$ 1,00 de taxa.

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
	
	//Método de realizar pagamento.
	public void realizarPagamento() {

	}

	//Returna true caso o comprador tenha fundos para realização da compra.
	public boolean checarFundos(Comprador comprador, double valorCompra) {

		boolean hasFundos = false;

		if (valorCompra <= comprador.getSaldo()) {

			hasFundos = true;
		}

		return hasFundos;
	}
	
	//Returna true caso a data de pagamento seja maior que a data do vencimento.
	public boolean verificavencimento(Date dataVencimento, Date dataPagamento) {

		boolean data = true;

		if (dataPagamento.after(dataVencimento)) {

			data = false;
		}

		return data;

	}

	//Converte um Objeto do tipo String para Date.
	protected Date convertStringtoDate(String data) throws ParseException {

		Date dataConvertida;

		dataConvertida = formatador.parse(data);

		return dataConvertida;

	}

}
