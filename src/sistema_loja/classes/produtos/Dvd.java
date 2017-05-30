package sistema_loja.classes.produtos;

import javafx.scene.image.Image;

public class Dvd extends ProdutoGenerico
{
	private String duracao;
	
	public Dvd(int codigo, String titulo, String autor, String duracao, double preco, Image imagem, int quantidade, String descricao) 
	{
		super(codigo, titulo, autor, preco, imagem, quantidade, descricao);
		this.duracao = duracao;
	}

	public String getDuracao() {
		return this.duracao;
	}
}
