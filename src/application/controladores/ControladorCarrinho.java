package application.controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.GerenciadorCenas;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class ControladorCarrinho extends Controlador implements Initializable{
	
	@FXML private Button continuarComprando;
	@FXML private Button finalizarCompra;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
	
	@FXML
	void comprar() throws IOException {
		GerenciadorCenas.irPara(1);
	}

}
