package application.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Classe controladora da barra de cima
 * 
 * @author �nio Jos�
 */
public class ControladorToolbar extends Controlador
{
	@FXML private Button voltar;
	@FXML private Button avan�ar;
	
	@FXML
	void voltar()
	{
		System.out.println("Teste voltar");
	}
	
	@FXML
	void avan�ar()
	{
		System.out.println("Teste avan�ar");
	}
}
