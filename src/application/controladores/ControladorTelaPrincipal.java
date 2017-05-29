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
import javafx.scene.layout.VBox;
import sistema_loja.classes.produtos.Cd;
import sistema_loja.classes.produtos.Dvd;
import sistema_loja.classes.produtos.Livro;
import sistema_loja.interfaces.Produto;

/**
 * Controlador da tela principal.
 * 
 * @author ï¿½nio Josï¿½
 */
public class ControladorTelaPrincipal extends Controlador implements Initializable
{
	@FXML private HBox secaoLivros;
	@FXML private HBox secaoDVDs;
	@FXML private HBox secaoCDs;
	@FXML private VBox secaoNovidades;
	
	@FXML private PasswordField campoSenhaFuncionario;
	
	/**
	 * Esse mï¿½todo ï¿½ chamado apï¿½s os elementos relacionados
	 * ao nosso .fxml estarem inicializados. Assim, podemos
	 * manipulï¿½-los sem o risco de ocorrer um NUllPointerException.
	 * 
	 * Nele, vamos identificar cada produto da nossa lista
	 * de produtos e inserï¿½-los em sua seï¿½ï¿½o.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{		
		Item item;
		
		// Vai adicionar cada produto da nossa lista
		// em sua respectiva seï¿½ï¿½o.
		for (Produto p : produtos)
		{
			item = new Item(p);
			
			// Descobrir a instï¿½ncia da variï¿½vel para
			// saber a seï¿½ï¿½o em que botar.
			if (p instanceof Livro)
				secaoLivros.getChildren().add(item);
			else if (p instanceof Dvd)
				secaoDVDs.getChildren().add(item);
			else if (p instanceof Cd)
				secaoCDs.getChildren().add(item);
		}
		
		// Adicionar os últimos produtos da lista na 
		// secao de novidades
		for (int i = produtos.size() - 1; i > produtos.size() - 9; i--)
		{
			secaoNovidades.getChildren().add(new Item(produtos.get(i)));
		}
	}
	
	/**
	 * Chamado pressionar uma tecla no passwordField.
	 * <p>
	 * Verifica se o usuï¿½rio deu enter e valida o login.
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
