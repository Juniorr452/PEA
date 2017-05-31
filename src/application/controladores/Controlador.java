package application.controladores;

import java.util.List;


import sistema_loja.classes.vendas.Venda;

import sistema_loja.interfaces.Produto;

public abstract class Controlador 
{
	protected final int PRINCIPAL   = 1;
	protected final int FUNCIONARIO = 2;
	protected final int PRODUTO     = 3;
	protected final int CARRINHO    = 4;
	protected final int BUSCA       = 5;
	
	protected static List<Produto> produtos;
	protected static List<ItemCarrinho> produtosCarrinho;
	protected static Produto produtoSelecionado;
	protected static List<Venda> produtosVendidos;
	
	// Vamos armazenar o texto digitado na barra
	// de busca nesse atributo.
	protected static String textoBusca;
	
	protected static double total = 0;
		
	public static void setListaProdutos(List<Produto> p)
	{
		produtos = p;
	}
	
	public static void setListaCarrinho(List<ItemCarrinho> p)
	{
		produtosCarrinho = p;
	}
}
