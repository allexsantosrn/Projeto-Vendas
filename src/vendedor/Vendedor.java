package vendedor;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import produto.Produto;

public class Vendedor {

	String nome;
	String cnpj;
	double saldo;
	double valoresReceber;
	int vendasRealizadas;
	Map<Object, Object> catalogo = new HashMap<Object, Object>();

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
	
	
	public void adicionarItemCatalogo(Vendedor vendedor, Produto produto) {
		catalogo.put(vendedor, produto);
	}
	
	/*
	public void adicionarItemCatalogo(Produto produto) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Informe o catálogo do produto (Inserir o cnpj do vendedor): ");
		String cnpj = in.next();
		
		
		
		
	}*/

	public void retornarCatalogoVendedor(Vendedor vendedor) {
		System.out.print(catalogo.values());
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
