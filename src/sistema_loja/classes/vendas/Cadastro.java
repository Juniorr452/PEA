package sistema_loja.classes.vendas;

import java.util.List;

import javafx.scene.image.Image;
import sistema_loja.classes.produtos.Cd;
import sistema_loja.classes.produtos.Dvd;
import sistema_loja.classes.produtos.Livro;
import sistema_loja.exceptions.CodigoJaExistenteException;
import sistema_loja.interfaces.Produto;

public class Cadastro 
{
	private static List<Produto> produtos;
	
	public Cadastro() {}
	
	public Cadastro(List<Produto> produtos)
	{
		this.produtos = produtos;
	}
	
	public void cadastrarProduto(Produto p) throws CodigoJaExistenteException, NumberFormatException
	{
		// Verificar se o código já existe e os números digitados.
		for(Produto produto : produtos)
			if (p.getCodigo() == produto.getCodigo())
					throw new CodigoJaExistenteException();
			else if(p.getCodigo() < 0 || p.getPreco() <= 0 || p.getQuantidade() <= 0)
				throw new NumberFormatException();
		
		// Adicionar na lista.
		produtos.add(p);
	}
}
