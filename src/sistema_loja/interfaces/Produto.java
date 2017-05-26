package sistema_loja.interfaces;

import javafx.scene.image.Image;

public interface Produto 
{
	public String getTitulo();
	public String getAutor();
	public Image getImage();
	public double getPreco();
	public int getQuantidade();
	public void setPreco(double valor);
	public void setQuantidade(int valor);
	public int getQuantidadeDesejada();
	public void setQuantidadeDesejada(int valor);
}
