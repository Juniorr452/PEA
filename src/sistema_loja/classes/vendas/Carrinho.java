package sistema_loja.classes.vendas;

import java.util.List;

import java.util.ArrayList;

import sistema_loja.interfaces.Produto;

public class Carrinho
{
	List<Produto> produtosCarrinho;
	double valorTotal;
	
	public Carrinho()
	{
		valorTotal = 0;
		produtosCarrinho = new ArrayList<Produto>();
	}

	public void addCarrinho(Produto elementoCarrinho)
	{
		double aux = elementoCarrinho.getPreco();
		valorTotal = aux + valorTotal;
		produtosCarrinho.add(elementoCarrinho);
	}
}
