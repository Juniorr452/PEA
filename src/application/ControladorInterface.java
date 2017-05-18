package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class ControladorInterface implements Initializable
{
	@FXML private AnchorPane    raizCena;
    @FXML private PasswordField campoSenhaFuncionario;
    
    //private GerenciadorCenas gerenciadorCenas;
    

    // Usaremos esse método ao invés do construtor para
    // passar os elementos da interface gráfica pras outras classes.
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		
	}

	/**
	 * Chamado pressionar uma tecla no passwordField
	 */
    @FXML
    private void validarSenhaFuncionario(KeyEvent event) 
    {
    	String senha = campoSenhaFuncionario.getText();
    	if (event.getCode() == KeyCode.ENTER && senha.equals("123"))
    	{
    		GerenciadorCenas.irPara(GerenciadorCenas.funcionario);
    	}	
    }
}
