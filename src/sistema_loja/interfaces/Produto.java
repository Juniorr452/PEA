package sistema_loja.interfaces;

import javafx.scene.image.Image;

public interface Produto 
{
	public int getCodigo();
	public String getTitulo();
	public String getAutor();
	public Image getImage();
	public double getPreco();
	public int getQuantidade();
	public String getDescricao();
	public void setPreco(double valor);
	public void setQuantidade(int valor);
}
