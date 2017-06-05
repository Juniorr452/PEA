package sistema_loja.classes.vendas;

import java.util.List;
import application.controladores.ItemCarrinho;

public class Venda
{
	private String nomeCliente;
	private String cpf;
	private double valorTotal;
	private String telefone;
	private String estadoCidade;
	private String endereço;
	private String numeroPedido;
	
	List<ItemCarrinho> produtosComprados;
	
	public Venda(List<ItemCarrinho> produtosComprados , double valorTotal , int contador){
		this.produtosComprados = produtosComprados;
		this.valorTotal = valorTotal;
		this.numeroPedido = Integer.toString(contador);
	}

	public String getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(String numeroPedido) {
		this.numeroPedido = numeroPedido;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEstadoCidade() {
		return estadoCidade;
	}

	public void setEstadoCidade(String estadoCidade) {
		this.estadoCidade = estadoCidade;
	}

	public String getEndereço() {
		return endereço;
	}

	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}

	public List<ItemCarrinho> getProdutosComprados() {
		return produtosComprados;
	}

	public void setProdutosComprados(List<ItemCarrinho> produtosComprados) {
		this.produtosComprados = produtosComprados;
	}

}
