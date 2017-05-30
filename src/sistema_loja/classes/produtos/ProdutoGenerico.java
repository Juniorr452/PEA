package sistema_loja.classes.produtos;

import javafx.scene.image.Image;
import sistema_loja.interfaces.Produto;

public abstract class ProdutoGenerico implements Produto
{
	private int codigo;
	private String titulo;
	private String autor;
	private String descricao;
	private double preco;
	private Image imagem;
	private int quantidade;
	
	public ProdutoGenerico(int codigo, String titulo, String autor, double preco, Image imagem, int quantidade, String descricao) 
	{
		this.codigo = codigo;
		this.titulo = titulo;
		this.autor = autor;
		this.preco = preco;
		this.imagem = imagem;
		this.quantidade = quantidade;
		
		if (descricao != null)
			this.descricao = descricao;
		else
			this.descricao = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean tellus nisl, efficitur eu urna eleifend, laoreet consectetur neque. Nunc bibendum dictum varius. Interdum et malesuada fames ac ante ipsum primis in faucibus. Cras volutpat quis erat egestas sagittis. Phasellus elementum volutpat tellus, sed vestibulum justo pharetra vitae. Cras a nisl non est interdum ornare vitae nec sapien. Suspendisse in porta purus, eu aliquet sem. Suspendisse sit amet aliquet eros. Etiam tristique, nunc a vehicula dignissim, dolor odio scelerisque lectus, ac tempor tortor velit sed mi. Maecenas vel nunc tortor. Duis venenatis a leo vitae porta. Duis scelerisque pulvinar finibus. Maecenas tincidunt vel lacus at vestibulum. Maecenas sodales tortor quis ex bibendum venenatis.";
	}
	
	@Override
	public int getCodigo() {
		return this.codigo;
	}

	@Override
	public String getTitulo() {
		return this.titulo;
	}

	@Override
	public String getAutor() {
		return this.autor;
	}

	@Override
	public Image getImage() {
		return this.imagem;
	}

	@Override
	public double getPreco() {
		return this.preco;
	}

	@Override
	public int getQuantidade() {
		return this.quantidade;
	}

	@Override
	public void setPreco(double valor) {
		this.preco = valor;
	}

	@Override
	public void setQuantidade(int valor) {
		this.quantidade = valor;
	}
	
	@Override
	public String getDescricao()
	{
		return this.descricao;
	}
}
