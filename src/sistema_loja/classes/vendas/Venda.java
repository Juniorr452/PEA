package sistema_loja.classes.vendas;


public class Venda {
	
	 private static String nomeCliente;
	 private static String cpf;
	 private static double valorTotal;
 
	 Venda(String nome, String cpf1, double valor){
		
		nomeCliente = nome;
		cpf = cpf1;
		valorTotal = valor;
		
	}	
}
