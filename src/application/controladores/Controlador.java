package application.controladores;

import java.util.List;

import sistema_loja.interfaces.Produto;

public abstract class Controlador 
{
	protected final int PRINCIPAL   = 1;
	protected final int FUNCIONARIO = 2;
	protected final int PRODUTO     = 3;
	protected final int CARRINHO    = 4;
	
	protected static List<Produto> produtos; 
	protected static Produto produtoSelecionado;
	
	public static void setListaProdutos(List<Produto> p)
	{
		produtos = p;
	}
}
