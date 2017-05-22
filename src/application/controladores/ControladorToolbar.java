package application.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

/**
 * Classe controladora da barra de cima
 * 
 * @author �nio Jos�
 */
public class ControladorToolbar extends Controlador
{
	@FXML private Button voltar;
	@FXML private Button avancar;
	@FXML private Button carrinho;
	
	@FXML
	void voltar()
	{
		System.out.println("Teste voltar");
	}
	
	@FXML
	void carrinho()
	{
		System.out.println("Teste carrinho");
	}
	
	@FXML
	void avancar()
	{
		System.out.println("Teste avançar");
	}
}
