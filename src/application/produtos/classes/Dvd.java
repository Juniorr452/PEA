package application.produtos.classes;

import application.interfaces.Produto;
import javafx.scene.image.Image;

public class Dvd implements Produto
{
	private String titulo;
	private String tempo;
	private String cantor;
	private double preco;
	private Image imagem;
	
	public Dvd(String titulo, String tempo, String cantor, double preco, Image imagem) {
		this.titulo = titulo;
		this.tempo = tempo;
		this.cantor = cantor;
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
	
	public String getTempo() {
		return tempo;
	}
	
	public String getCantor() {
		return cantor;
	}

	
	
}
