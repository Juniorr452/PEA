package application.interfaces;

import javafx.scene.image.Image;

public interface Produto {
	
	public String getTitulo();
	public double getPreco();
	public void setPreco(double valor);
	public Image getImage();
}
