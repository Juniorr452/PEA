package application.controladores;

import java.util.List;

import sistema_loja.interfaces.Produto;

public abstract class Controlador 
{
	protected final int PRINCIPAL   = 0;
	protected final int FUNCIONARIO = 1;
	protected final int PRODUTO     = 2;
	protected final int CARRINHO    = 3;
	
	protected static List<Produto> produtos; 
	
	public static void setListaProdutos(List<Produto> p)
	{
		produtos = p;
	}
}
