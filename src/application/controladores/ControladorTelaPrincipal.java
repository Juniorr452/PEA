package application.controladores;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * Controlador da tela principal.
 * 
 * @author Ênio José
 */
public class ControladorTelaPrincipal extends Controlador
{
	@FXML private PasswordField campoSenhaFuncionario;
	
	/**
	 * Chamado pressionar uma tecla no passwordField.
	 * <p>
	 * Verifica se o usuário deu enter e valida o login.
	 */
    @FXML
    private void validarSenhaFuncionario(KeyEvent event) throws IOException
    {
    	String senha = campoSenhaFuncionario.getText();
    	if (event.getCode() == KeyCode.ENTER && senha.equals("123"))
    	{
    		GerenciadorCenas.irPara(funcionario);
    	}	
    }
}
