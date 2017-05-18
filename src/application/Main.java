package application;

import application.controladores.ControladorCenas;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application 
{
	@Override
	public void start(Stage janela) 
	{
		Parent telaPrincipal;
		Scene  scene;

		try 
		{
			// Vamos carregar a tela principal e 
			// mandá-la para a classe ControladorCenas.
			telaPrincipal = FXMLLoader.load(getClass().getResource("cenas/Principal.fxml"));
			ControladorCenas.inicializar(janela);
			
			// Vamos criar uma cena com o arquivo que
			// carregamos e colocar um estilo css nele.
			scene = new Scene(telaPrincipal);
			scene.getStylesheets().add(getClass().getResource("cenas/application.css").toExternalForm());
			
			// Colocaremos algumas configurações
			// na nossa janela e mostramos ela.
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
