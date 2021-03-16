package comprador;

import java.util.Collection;
import java.util.HashSet;

public class Comprador {

	private String cpf;
	private String nome;
	private double saldo;
	private double valoresaPagar;
	private int comprasRealizadas;

	private Collection<Comprador> compradores = new HashSet<>();

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getValoresaPagar() {
		return valoresaPagar;
	}

	public void setValoresaPagar(double valoresaPagar) {
		this.valoresaPagar = valoresaPagar;
	}

	public int getComprasRealizadas() {
		return comprasRealizadas;
	}

	public void setComprasRealizadas(int comprasRealizadas) {
		this.comprasRealizadas = comprasRealizadas;
	}

	public void adicionarComprador(Comprador comprador) {
		compradores.add(comprador);
	}

	@Override
	public String toString() {
		return "CPF: " + this.cpf + "\nNome: " + this.nome + "\nSaldo: " + this.saldo + "\nValores a Pagar: "
				+ this.valoresaPagar + "\nCompras Realizadas: " + this.comprasRealizadas;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		Comprador other = (Comprador) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

}
