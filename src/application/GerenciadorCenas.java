package application;

import java.util.List;

import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Cada controlador de cena/arquivo .fxml 
 * diferente deverá herdar dessa classe.
 * 
 * @author Ênio José
 */
public abstract class GerenciadorCenas
{
	private static Pane  root;
	private static Stage janela;
	private static List<ScrollPane> fxml;

	public static void inicializar(Stage j, Pane r, List<ScrollPane> cena)
	{
		janela = j;
		fxml   = cena;
		root   = r;
		
		// Vamos adicionar a tela principal em baixo do toolbar.
		root.getChildren().add(fxml.get(0));
		
		// Vamos colocar isso como a nossa cena, fazer
		// algumas configurações e mostrar a janela.
		janela.setScene(new Scene(root));
		janela.setTitle("PEA");
		janela.sizeToScene();
		janela.setResizable(false);
		janela.show();
	}
	
	/**
	 * Remove o elemento abaixo da toolbar
	 * e adiciona outro (A tela que você quer ir).
	 */
	public static void irPara(int indice)
	{
		root.getChildren().remove(1);
		root.getChildren().add(fxml.get(indice));
	}
	
	public static void irPara(ScrollPane p)
	{
		root.getChildren().remove(1);
		root.getChildren().add(p);
	}
}