package venda;

import java.util.Collection;
import java.util.HashSet;

import comprador.Comprador;
import produto.Produto;
import vendedor.Vendedor;

public class Venda {
	
	Comprador comprador;
	Vendedor vendedor;
	
	private Collection<Produto> itens = new HashSet<>();
	
	public void adicionarItemVenda(Produto produto) {
		itens.add(produto);		
	}	
	
	public void getItensVenda() {
		int i=1;
		System.out.println("Itens da venda: ");
		for (Produto produto : itens) {
			
			System.out.println("Produto" + "[" + i + "]:" + " " + produto.getCodigo()+" - "+produto.getNome()+" - "+produto.getPrecoUnitario());
			i++;
		}
	}	
	
	public double getValorProdutos () {
		
		double total = 0;
		
		for (Produto produto : itens) {
			
			total = total + produto.getPrecoUnitario();
		}
		
		return total;
	}

}
