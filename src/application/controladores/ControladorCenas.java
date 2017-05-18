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
 * diferente dever� herdar dessa classe.
 * 
 * @author �nio Jos�
 */
public abstract class ControladorCenas
{
	@FXML protected Button voltar;
	@FXML protected Button avan�ar;
	
	private static Stage janela;
	
	/**
	 * Vamos pegar a refer�ncia da janela para
	 * fazer a mudan�a de cenas.
	 */
	public static void inicializar(Stage j)
	{
		janela = j;
	}
	
	/**
	 * Ir� carregar o arquivo .fxml do disco e
	 * coloc�-lo na janela.
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
