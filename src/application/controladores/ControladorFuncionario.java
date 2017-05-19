package application.controladores;

import java.io.IOException;

import javafx.fxml.FXML;

public class ControladorFuncionario extends Controlador
{
	@FXML
	private void sair() throws IOException
	{
		GerenciadorCenas.irPara(principal);
	}
}
