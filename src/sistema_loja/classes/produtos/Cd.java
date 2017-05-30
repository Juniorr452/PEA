package sistema_loja.classes.produtos;

import javafx.scene.image.Image;

public class Cd extends ProdutoGenerico
{
	private String ano;
	
	public Cd(int codigo, String titulo, String autor, String ano, double preco, Image imagem, int quantidade, String descricao) 
	{
		super(codigo, titulo, autor, preco, imagem, quantidade, descricao);
		this.ano = ano;
	}

	public String getAno() {
		return ano;
	}
}