package sistema_loja.classes.vendas;

import java.util.List;
import application.controladores.ItemCarrinho;

public class Venda{
	
	 private  String nomeCliente;
	 private  String cpf;
	 private  double valorTotal;
	 List<ItemCarrinho> produtosComprados;
	
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
	public List<ItemCarrinho> getProdutosComprados() {
		return produtosComprados;
	}
	public void setProdutosComprados(List<ItemCarrinho> produtosComprados) {
		this.produtosComprados = produtosComprados;
	}
	 
	 
	 
}
