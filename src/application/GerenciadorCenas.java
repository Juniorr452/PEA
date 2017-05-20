package application;

import java.io.IOException;
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
	private static int indiceAtual;

	public static void inicializar(Stage j, Pane r, List<ScrollPane> cena)
	{
		indiceAtual = 0;
		janela = j;
		fxml   = cena;
		root   = r;
		
		// Vamos adicionar a tela principal em baixo do toolbar.
		root.getChildren().add(0, fxml.get(0));
		
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
	public static void irPara(int indice) throws IOException
	{
		root.getChildren().remove(fxml.get(indiceAtual));
		root.getChildren().add(0, fxml.get(indice));
		indiceAtual = indice;
	}
}
