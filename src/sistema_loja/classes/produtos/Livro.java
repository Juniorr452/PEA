package sistema_loja.classes.produtos;

import javafx.scene.image.Image;
import sistema_loja.interfaces.Produto;

public class Livro extends ProdutoGenerico implements Produto
{
	private String categoria;
	
	public Livro(int codigo, String titulo, String autor, String categoria, double preco, Image imagem, int quantidade, String descricao) 
	{
		super(codigo, titulo, autor, preco, imagem, quantidade, descricao);
		this.categoria = categoria;
	}

	public String getCategoria() {
		return this.categoria;
	}
}
