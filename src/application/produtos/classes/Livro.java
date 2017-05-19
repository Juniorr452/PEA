package application.produtos.classes;

import application.interfaces.Produto;
import javafx.scene.image.Image;

public class Livro implements Produto 
{
	private String titulo;
	private String autor;
	private String categoria;
	private double preco;
	private Image imagem;
	
	public Livro(String titulo, String autor, String categoria, double preco, Image imagem) 
	{
		this.titulo = titulo;
		this.autor = autor;
		this.categoria = categoria;
		this.preco = preco;
		this.imagem = imagem;
	}
	
	@Override
	public String getTitulo() {
		return titulo;
	}

	@Override
	public double getPreco() {
		return preco;
	}
	
	@Override
	public void setPreco(double valor) {
		preco = valor;
	}

	@Override
	public Image getImage() {
		return imagem;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public String getCategoria() {
		return categoria;
	}
}
