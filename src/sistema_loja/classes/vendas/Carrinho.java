package sistema_loja.classes.vendas;

import java.util.ArrayList;
import java.util.List;

import application.controladores.Controlador;
import application.controladores.ItemCarrinho;
import sistema_loja.exceptions.QuantidadeIndisponivelException;
import sistema_loja.exceptions.QuantidadeMaximaException;
import sistema_loja.interfaces.Produto;

public class Carrinho
{
	private List<ItemCarrinho> produtosCarrinho;
	
	public Carrinho()
	{
		produtosCarrinho = new ArrayList<ItemCarrinho>();
	}

	public void adicionarItem(Produto p, int qtdDesejada) throws QuantidadeIndisponivelException
	{
		int qtdProduto = p.getQuantidade();
		ItemCarrinho i = null;
		
		// Verificamos se a quantidade desejada esta disponivel para compra
		if (qtdDesejada <= qtdProduto)
		{
			// Vamos procurar na lista do carrinho se o produto já foi
			// adicionado.
			for (ItemCarrinho itemCarrinho : produtosCarrinho) 
				if(p.getCodigo() == itemCarrinho.getCodigo()) 
				{
					i = itemCarrinho;
					break;
				}
			
			if(i != null) // Se o usuário já tinha adicionado o produto...
				i.setQtd(qtdDesejada);		
			else          // Se não, cria um novo item no carrinho.
			{
				i = new ItemCarrinho(p, qtdDesejada);
				produtosCarrinho.add(i);
			}
			// Diminui a quantidade do produto
			p.setQuantidade(qtdProduto - qtdDesejada);
		}
		else
			throw new QuantidadeIndisponivelException();
	}
	
	public void removerItem(ItemCarrinho i)
	{
		// Adicionar a quantidade de volta ao produto removido.
		for (Produto p : Controlador.getProdutos()) 
			if(i.getCodigo() == p.getCodigo()) 
				p.setQuantidade(p.getQuantidade() + i.getQtd());
		
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
	
	public void verificarQuantidadeProdutos() throws QuantidadeMaximaException
	{
		for(ItemCarrinho i : produtosCarrinho)
			if (i.getQtd() > 10)
				throw new QuantidadeMaximaException();
	}
}
