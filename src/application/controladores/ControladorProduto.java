package application.controladores;

import java.awt.Label;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class ControladorProduto extends Controlador {
	
	@FXML private Button adicionarCarrinho;
	@FXML private static Label tituloItem;
	@FXML private static ImageView capaItem;
	@FXML private static Label autorItem;
	@FXML private static Label precoItem;
	
	@FXML
	void adicionarCarrinho() 
	{
		System.out.println("Adicionando no carrinho");
	}
	
	public static void receberDados(Image img, String tit, String aut, double prec) {
		tituloItem.setText(tit);
		capaItem.setImage(img);
		autorItem.setText(aut);
		precoItem.setText(Double.toString(prec));
	}
}
