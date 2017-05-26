package sistema_loja.classes.produtos;

import javafx.scene.image.Image;
import sistema_loja.interfaces.Produto;

public class Livro implements Produto 
{
	private String titulo;
	private String autor;
	private String categoria;
	private double preco;
	private Image imagem;
	private int quantidade;
	private int qtd_desejada;
	
	public Livro(String titulo, String autor, String categoria, double preco, Image imagem, int quantidade) 
	{
		this.titulo = titulo;
		this.autor = autor;
		this.categoria = categoria;
		this.preco = preco;
		this.imagem = imagem;
		this.quantidade = quantidade;
	}
	
	@Override
	public String getTitulo() 
	{
		return titulo;
	}

	@Override
	public double getPreco() 
	{
		return preco;
	}

	@Override
	public Image getImage() 
	{
		return imagem;
	}
	
	public String getAutor() 
	{
		return autor;
	}
	
	public String getCategoria() 
	{
		return categoria;
	}
	
	@Override
	public int getQuantidade() {
		return this.quantidade;
	}

	@Override
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}	
	
	@Override
	public void setPreco(double valor) {
		preco = valor;
	}
	
	@Override
	public int getQuantidadeDesejada() {
		return qtd_desejada;
	}
	
	@Override
	public void setQuantidadeDesejada(int valor) {
		qtd_desejada = valor;
	}
	
}
