package comprador;

public class Comprador {

	private String nome;
	private String cpf;
	private double saldo;
	private double valoresPagar;
	private int comprasRealizadas;

	public Comprador() {

	}
	
	public Comprador(String cpf, String nome, double saldo) {
		this.cpf = cpf;
		this.nome = nome;
		this.saldo = saldo;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getValoresPagar() {
		return valoresPagar;
	}

	public void setValoresPagar(double valoresPagar) {
		this.valoresPagar = valoresPagar;
	}

	public int getComprasRealizadas() {
		return comprasRealizadas;
	}

	public void setComprasRealizadas(int comprasRealizadas) {
		this.comprasRealizadas = comprasRealizadas;
	}
	
	@Override
	public String toString() {
		return "CPF: "+this.cpf + "\nNome: " + this.nome + "\nSaldo: " + this.saldo 
				+ "\nValores a Pagar: " + this.valoresPagar + "\nCompras Realizadas: " + this.comprasRealizadas;
				
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
