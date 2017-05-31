package sistema_loja.classes.vendas;

import java.util.List;

import sistema_loja.interfaces.Produto;


public class Venda{
	
	 private  String nomeCliente;
	 private  String cpf;
	 private  double valorTotal;
	 List<Produto> produtosComprados;
 
	 Venda(List<Produto> produtosComprados , double valorTotal , String nomeCliente , String cpf){
		 this.produtosComprados = produtosComprados;
		 this.valorTotal = valorTotal;
		 this.nomeCliente = nomeCliente;
		 this.cpf = cpf; 
	 }

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	 
}
