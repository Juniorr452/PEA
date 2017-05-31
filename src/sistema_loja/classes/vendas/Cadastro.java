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
	
	public void cadastrarLivro(String codigo, String titulo, String autor, String categoria, String preco, Image imagem, String quantidade)
	{
		Produto p = new Livro(Integer.parseInt(codigo),
				titulo, autor, categoria, 
				Double.parseDouble(preco), imagem, 
				Integer.parseInt(quantidade), null);
		produtos.add(p);
	}
	
	public void cadastrarDVD(String codigo, String titulo, String autor, String duracao, String preco, Image imagem, String quantidade)
	{
		Produto p = new Dvd(Integer.parseInt(codigo),
							titulo, autor, duracao, 
							Double.parseDouble(preco), imagem, 
							Integer.parseInt(quantidade), null);
		produtos.add(p);
	}
	
	public void cadastrarCD(String codigo, String titulo, String autor, String ano, String preco, Image imagem, String quantidade)
	{
		Produto p = new Cd(Integer.parseInt(codigo),
				titulo, autor, ano, 
				Double.parseDouble(preco), imagem, 
				Integer.parseInt(quantidade), null);
		produtos.add(p);
	}
}
