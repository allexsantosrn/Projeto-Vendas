package vendedor;

import java.util.Collection;
import java.util.HashSet;
import produto.Produto;

public class Vendedor {

	String nome;
	String cnpj;
	double saldo;
	double valoresReceber;
	int vendasRealizadas;
	private Collection<Produto> catalogo = new HashSet<>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getValoresReceber() {
		return valoresReceber;
	}

	public void setValoresReceber(double valoresReceber) {
		this.valoresReceber = valoresReceber;
	}

	public int getVendasRealizadas() {
		return vendasRealizadas;
	}

	public void setVendasRealizadas(int vendasRealizadas) {
		this.vendasRealizadas = vendasRealizadas;
	}

	@Override
	public String toString() {
		return "CNPJ: " + this.cnpj + "\nNome: " + this.nome + "\nSaldo: " + this.saldo + "\nValores a Receber: "
				+ this.valoresReceber + "\nVendas Realizadas: " + this.vendasRealizadas;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendedor other = (Vendedor) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		return true;
	}

}
