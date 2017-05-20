package sistema_loja.interfaces;

import javafx.scene.image.Image;

public interface Produto 
{
	public String getTitulo();
	public String getAutor();
	public double getPreco();
	public void setPreco(double valor);
	public Image getImage();
}
