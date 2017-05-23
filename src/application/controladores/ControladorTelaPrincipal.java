package application.controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.GerenciadorCenas;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import sistema_loja.classes.produtos.Cd;
import sistema_loja.classes.produtos.Dvd;
import sistema_loja.classes.produtos.Livro;
import sistema_loja.interfaces.Produto;

/**
 * Controlador da tela principal.
 * 
 * @author �nio Jos�
 */
public class ControladorTelaPrincipal extends Controlador implements Initializable
{
	@FXML private HBox secaoLivros;
	@FXML private HBox secaoDVDs;
	@FXML private HBox secaoCDs;
	
	@FXML private PasswordField campoSenhaFuncionario;
	
	/**
	 * Esse m�todo � chamado ap�s os elementos relacionados
	 * ao nosso .fxml estarem inicializados. Assim, podemos
	 * manipul�-los sem o risco de ocorrer um NUllPointerException.
	 * 
	 * Nele, vamos identificar cada produto da nossa lista
	 * de produtos e inser�-los em sua se��o.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		Item item;
		
		// Vai adicionar cada produto da nossa lista
		// em sua respectiva se��o.
		for (Produto p : produtos)
		{
			item = new Item(p);
			
			// Descobrir a inst�ncia da vari�vel para
			// saber a se��o em que botar.
			if (p instanceof Livro)
				secaoLivros.getChildren().add(item);
			else if (p instanceof Dvd)
				secaoDVDs.getChildren().add(item);
			else if (p instanceof Cd)
				secaoCDs.getChildren().add(item);
		}
	}
	
	/**
	 * Chamado pressionar uma tecla no passwordField.
	 * <p>
	 * Verifica se o usu�rio deu enter e valida o login.
	 */
    @FXML
    private void validarSenhaFuncionario(KeyEvent event) throws IOException
    {
    	String senha = campoSenhaFuncionario.getText();
    	if (event.getCode() == KeyCode.ENTER && senha.equals("123"))
    	{
    		GerenciadorCenas.irPara(FUNCIONARIO);
    	}	
    }
}
