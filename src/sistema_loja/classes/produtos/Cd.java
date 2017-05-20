package sistema_loja.classes.produtos;

import javafx.scene.image.Image;
import sistema_loja.interfaces.Produto;

public class Cd implements Produto 
{
	private String titulo;
	private String autor;
	private String ano;
	private double preco;
	private Image imagem;
	
	public Cd(String titulo, String autor, String ano, double preco, Image imagem) 
	{
		this.titulo = titulo;
		this.autor = autor;
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
	
	public String getAutor() {
		return autor;
	}
	
	public String getAno() {
		return ano;
	}
}
