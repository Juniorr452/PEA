package application;

import java.io.IOException;
import java.util.List;

import application.controladores.ControladorTelaPrincipal;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Cada controlador de cena/arquivo .fxml 
 * diferente dever� herdar dessa classe.
 * 
 * @author �nio Jos�
 */
public abstract class GerenciadorCenas
{
	private static Pane root;
	private static FXMLLoader[] loaders;

	public static void inicializar(Stage janela, Pane toolbar, FXMLLoader... l) throws IOException
	{
		loaders = l;
		root = toolbar;
		
		// vamos carregar a tela principal pelo loader na
		// posi��o zero.
		ScrollPane telaPrincipal = loaders[0].load();
		
		// Vamos adicionar a tela principal em baixo do toolbar.
		root.getChildren().add(telaPrincipal);
		
		// Vamos colocar isso como a nossa cena, fazer
		// algumas configura��es e mostrar a janela.
		janela.setScene(new Scene(root));
		janela.setTitle("PEA");
		janela.sizeToScene();
		janela.setResizable(false);
		janela.show();
	}

	/**
	 * Remove o elemento abaixo da toolbar
	 * e adiciona outro (A tela que voc� quer ir).
	 */
	public static void irPara(int indice) throws IOException
	{
		// Setar o root e controlador null para poder carregar denovo
		// Isso n�o � recomendado na verdade. Precisariamos de uma
		// outra inst�ncia dos loaders fxml, mas isso ia dar mais trabalho kk.
		loaders[indice].setRoot(null);
		loaders[indice].setController(null);
		root.getChildren().remove(1);
		root.getChildren().add(loaders[indice].load());
	}
}