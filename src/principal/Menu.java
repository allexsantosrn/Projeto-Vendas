package principal;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {

		// Tela de apresentação do sistema

		Scanner in = new Scanner(System.in);

		Functions functions = new Functions();

		int option;

		do {

			System.out.println("$$$$$ Sistema de Cadastro de Vendas $$$$$");
			System.out.println("");

			System.out.println("- Escolha uma das opções abaixo: ");
			System.out.println("");

			System.out.println("1 - Cadastrar Comprador");
			System.out.println("2 - Consultar Comprador");
			System.out.println("3 - Listar Compradores");
			System.out.println("4 - Cadastrar Vendedor");
			System.out.println("5 - Consultar Vendedor");
			System.out.println("6 - Listar Vendedores");
			System.out.println("7 - Cadastrar Produto");
			System.out.println("8 - Consultar Produto");
			System.out.println("9 - Listar Produtos");
			System.out.println("10 - Cadastrar Venda");			
			System.out.println("0 - Sair");

			System.out.print("Selecionar Opção: ");
			option = in.nextInt();

			switch (option) {

			case 1:
				functions.cadastrarComprador();
				break;

			case 2:
				functions.consultarComprador();
				break;

			case 3:
				functions.listarCompradores();
				break;

			case 4:
				functions.cadastrarVendedor();
				break;

			case 5:
				functions.consultarVendedor();
				break;

			case 6:
				functions.listarVendedores();
				break;

			case 7: 
				functions.cadastrarProduto(); 
				break; 
			
			case 8: 
				functions.consultarProduto(); 
				break; 
			
			case 9: 
				functions.listarProdutos(); 
				break; 
				
			case 10: 
				functions.cadastrarVenda(); 
				break; 

			case 0:
				break;

			default:
				System.out.println("Opção inválida. Escolha uma opção entre 0 e 10!!!");
				break;
			}

		}

		while (option != 0);
		System.out.println("Saindo...volte sempre!!!");
		in.close();

	}

}
