package pagamento;

import java.text.ParseException;
import java.util.Date;

import comprador.Comprador;
import vendedor.Vendedor;

public class PagamentoBoleto extends FormaPagamento{
	
	private Date dataVencimento;
	
	public Date getDataVencimento() {
		return dataVencimento;
	}
	
	//Método que converte a data de vencimento de String para Date.
	public void setDataVencimento(String dataVencimento) throws ParseException {
		this.dataVencimento = formatador.parse(dataVencimento);
	}
	
	//Método que realiza o pagamento por boleto bancário.
	public void realizarPagamento(Vendedor vendedor, Comprador comprador, double valorCompra,
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

		if (!checarFundos(comprador, valorCompra)) {

			System.out.println("O comprador não possui fundos para realização da compra.");
			System.out.println("");
		}

		else if (!verificavencimento(dataVencimentoConvertida, dataPagamentoConvertida)) {

			System.out.println(
					"Boleto vencido. Não é permitido realizar pagamentos após a data de vencimento do boleto.");
			System.out.println("");
		}

		else {

			double creditoVendedor = valorCompra - valorEmissaoBoleto;
			comprador.debitaSaldoVendedor(valorCompra);
			comprador.incrementaComprasRealizadas();

			vendedor.incrementaValoresaReceber(creditoVendedor);
			vendedor.incrementaVendasRealizadas();

			System.out.println("Pagamento realizado com sucesso.");
			System.out.println("");

		}

	}
	
	
}
