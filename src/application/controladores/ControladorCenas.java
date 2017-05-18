package application.controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Cada controlador de cena/arquivo .fxml 
 * diferente deverá herdar dessa classe.
 * 
 * @author Ênio José
 */
public abstract class ControladorCenas
{
	@FXML protected Button voltar;
	@FXML protected Button avançar;
	
	private static Stage janela;
	
	/**
	 * Vamos pegar a referência da janela para
	 * fazer a mudança de cenas.
	 */
	public static void inicializar(Stage j)
	{
		janela = j;
	}
	
	/**
	 * Irá carregar o arquivo .fxml do disco e
	 * colocá-lo na janela.
	 * 
	 * @param nome
	 */
	protected void irPara(String nome) throws IOException
	{
		Parent proximaTela;
		Scene  scene;
		
		proximaTela = FXMLLoader.load(getClass().getResource("../cenas/" + nome + ".fxml"));
		scene = new Scene(proximaTela);
		
		janela.setScene(scene);
	}
	
	@FXML private void voltar()
	{
		
	}
}
