package sistema_loja.classes.vendas;

import java.util.List;

import javafx.scene.image.Image;
import sistema_loja.classes.produtos.Cd;
import sistema_loja.classes.produtos.Dvd;
import sistema_loja.classes.produtos.Livro;
import sistema_loja.interfaces.Produto;

public class Cadastro 
{
	private List<Produto> produtos;
	
	public Cadastro(List<Produto> produtos)
	{
		this.produtos = produtos;
	}
	
	public void cadastrarLivro(String titulo, String autor, String categoria, String preco, Image imagem, String quantidade)
	{
		Produto p = new Livro(titulo, autor, categoria, 
				Double.parseDouble(preco), imagem, 
				Integer.parseInt(quantidade));
		produtos.add(p);
	}
	
	public void cadastrarDVD(String titulo, String autor, String duracao, String preco, Image imagem, String quantidade)
	{
		Produto p = new Dvd(titulo, autor, duracao, 
							Double.parseDouble(preco), imagem, 
							Integer.parseInt(quantidade));
		produtos.add(p);
	}
	
	public void cadastrarCD(String titulo, String autor, String ano, String preco, Image imagem, String quantidade)
	{
		Produto p = new Cd(titulo, autor, ano, 
				Double.parseDouble(preco), imagem, 
				Integer.parseInt(quantidade));
		produtos.add(p);
	}
}
