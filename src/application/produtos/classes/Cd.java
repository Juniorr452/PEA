package application.produtos.classes;

import application.interfaces.Produto;
import javafx.scene.image.Image;

public class Cd implements Produto 
{
	private String titulo;
	private String cantor;
	private String ano;
	private double preco;
	private Image imagem;
	
	public Cd(String titulo, String cantor, String ano, double preco, Image imagem) 
	{
		this.titulo = titulo;
		this.cantor = cantor;
		this.ano = ano;
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
	
	public String getCantor() {
		return cantor;
	}
	
	public String getAno() {
		return ano;
	}
}
