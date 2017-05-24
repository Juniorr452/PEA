package application;

import java.io.IOException;

import application.controladores.ControladorToolbar;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Cada controlador de cena/arquivo .fxml 
 * diferente deverá herdar dessa classe.
 * 
 * @author Ênio José
 */
public abstract class GerenciadorCenas
{
	private static AnchorPane root;
	// Precisaremos da instância da classe controladora
	// de toolbar para acessar seus métodos.
	private static ControladorToolbar controladorToolbar;
	private static FXMLLoader[] loaders;

	public static void inicializar(Stage janela, FXMLLoader... l) throws IOException
	{
		loaders = l;
		root    = loaders[0].load();
		controladorToolbar = loaders[0].getController();
		
		// vamos carregar a tela principal pelo loader na
		// posição zero.
		ScrollPane telaPrincipal = loaders[1].load();
		
		
		// Vamos adicionar a tela principal em baixo do toolbar.
		root.getChildren().add(telaPrincipal);
		controladorToolbar.adicionarCena(telaPrincipal, 1);
		
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
		Parent cenaNova;
		Parent cenaAtual;
		
		// Setar o root e controlador null para poder carregar denovo
		// Isso não é recomendado na verdade. Precisariamos de uma
		// outra instância dos loaders fxml, mas isso ia dar mais trabalho kk.
		loaders[indice].setRoot(null);
		loaders[indice].setController(null);
		
		// Pegar a referência da cena atual e carregar
		// a que o usuário solicitou para ir.
		cenaAtual = (Parent) root.getChildren().get(1);
		cenaNova  = loaders[indice].load();
		
		// Adiciona a cena atual na pilha
		// da toolbar para poder voltar mais tarde.
		controladorToolbar.adicionarCena(cenaAtual, indice);
		root.getChildren().remove(1);
		root.getChildren().add(cenaNova);
	}
	
	/**
	 * Método utilizado pelo ControladorToolbar
	 * para setar a cena que o usuário está voltando.
	 * @param p
	 */
	public static void irPara(Parent p)
	{
		root.getChildren().remove(1);
		root.getChildren().add(p);
	}
}