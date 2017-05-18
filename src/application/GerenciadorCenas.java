package application;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class GerenciadorCenas
{
	public static final int principal   = 0;
	public static final int funcionario = 1;
	
	private static AnchorPane root;
	private static List<ScrollPane> cenas;
	private static ScrollPane telaPrincipal;
	private static ScrollPane telaFuncionario;
	
	public static void inicializar(AnchorPane root, ScrollPane telaFuncionario)
	{
		GerenciadorCenas.root = root;
		GerenciadorCenas.telaFuncionario = telaFuncionario;
		GerenciadorCenas.telaPrincipal = (ScrollPane) root.getChildren().get(0);
		
		//GerenciadorCenas.cenas.add(GerenciadorCenas.telaPrincipal);
		
		System.out.println(GerenciadorCenas.root);
		System.out.println(GerenciadorCenas.telaFuncionario);
	}
	
	public static void irPara(int tela)
	{
		ScrollPane proximaTela;
		switch(tela)
		{
		case 0:
			proximaTela = telaPrincipal;
			break;
			
		case 1:
			proximaTela = telaFuncionario;
			break;
			
		default:
			proximaTela = null;
		}
		
		root.getChildren().set(0, proximaTela);
		root.getChildren().get(0).setLayoutX(1);
		root.getChildren().get(0).setLayoutY(62);
		
		//cenas.add(proximaTela);
	}
	
	public void voltar()
	{
		
	}
	
	public void avançar()
	{
		
	}
}
