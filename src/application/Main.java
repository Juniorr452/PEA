package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;

public class Main extends Application 
{
	@Override
	public void start(Stage janela) 
	{
		AnchorPane root;
		ScrollPane telaFuncionario;

		try 
		{
			root = (AnchorPane) FXMLLoader.load(getClass().getResource("cenas/Principal.fxml"));
			telaFuncionario = (ScrollPane) FXMLLoader.load(getClass().getResource("cenas/Funcionario.fxml"));
			
			GerenciadorCenas.inicializar(root, telaFuncionario);
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("cenas/application.css").toExternalForm());
			janela.setScene(scene);
			janela.setTitle("PEA");
			janela.setResizable(false);
			janela.show();
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
