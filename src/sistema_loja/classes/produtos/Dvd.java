package sistema_loja.classes.produtos;

import javafx.scene.image.Image;
import sistema_loja.interfaces.Produto;

public class Dvd implements Produto
{
	private String titulo;
	private String autor;
	private String duracao;
	private double preco;
	private Image imagem;

	public Dvd(String titulo, String autor, String duracao, double preco, Image imagem) 
	{
		this.titulo = titulo;
		this.autor = autor;
		this.duracao = duracao;
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
	
	public String getDuracao() {
		return autor;
	}
	
	public String getAutor() {
		return autor;
	}

	
	
}
