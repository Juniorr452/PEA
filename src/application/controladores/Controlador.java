package application.controladores;

import java.util.ArrayList;
import java.util.List;

import sistema_loja.classes.vendas.Carrinho;
import sistema_loja.classes.vendas.Venda;

import sistema_loja.interfaces.Produto;

public abstract class Controlador 
{
	protected final int PRINCIPAL   = 1;
	protected final int FUNCIONARIO = 2;
	protected final int PRODUTO     = 3;
	protected final int CARRINHO    = 4;
	protected final int BUSCA       = 5;
	protected final int VENDA       = 6;
	
	protected static Carrinho carrinho;
	protected static Produto produtoSelecionado;
	protected static List<Venda> produtosVendidos;
	protected static List<Produto> produtos;
	
	// Vamos armazenar o texto digitado na barra
	// de busca nesse atributo.
	protected static String textoBusca;
	
	public static void inicializar(List<Produto> p)
	{
		produtos = p;
		carrinho = new Carrinho();
		produtosVendidos = new ArrayList<Venda>();
	}
	
	protected void resetarCarrinho()
	{
		carrinho.getProdutos().clear();
	}
}