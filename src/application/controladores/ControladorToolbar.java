package application.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Classe controladora da barra de cima
 * 
 * @author Ênio José
 */
public class ControladorToolbar extends Controlador
{
	@FXML private Button voltar;
	@FXML private Button avançar;
	
	@FXML
	void voltar()
	{
		System.out.println("Teste voltar");
	}
	
	@FXML
	void avançar()
	{
		System.out.println("Teste avançar");
	}
}
