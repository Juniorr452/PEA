package sistema_loja.classes.vendas;

import java.util.ArrayList;
import java.util.List;

import application.controladores.ItemCarrinho;

import sistema_loja.interfaces.Produto;

public class Carrinho
{
	private List<ItemCarrinho> produtosCarrinho;
	
	public Carrinho()
	{
		produtosCarrinho = new ArrayList<ItemCarrinho>();
	}

	public void adicionarItem(ItemCarrinho i)
	{
		produtosCarrinho.add(i);
	}
	
	public void removerItem(ItemCarrinho i)
	{
		produtosCarrinho.remove(i);
	}
	
	public double calcularValorTotal()
	{
		double total = 0;
			
		// Percorre a lista do carrinho, pegando item por item
		// e calculando o total do valor do carrinho
		for (ItemCarrinho p : produtosCarrinho) 
			total += p.getPreco() * p.getQtd();
		
		// Somando alguns precos, a parte decimal estava ficando gigante
		// portando usamos esse retorno para truncarmos em 2 casas decimais.
		return Math.floor(total * 100) / 100;
	}
	
	public List<ItemCarrinho> getProdutos()
	{
		return this.produtosCarrinho;
	}
	
	public void esvaziar()
	{
		produtosCarrinho.clear();
	}
}
