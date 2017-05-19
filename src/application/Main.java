package application;

import java.util.ArrayList;
import java.util.List;

import application.controladores.GerenciadorCenas;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;

public class Main extends Application 
{
	@Override
	public void start(Stage janela) 
	{
		List<ScrollPane> fxml;
		Pane root;

		try 
		{
			// Carregar a toolbar.
			root = FXMLLoader.load(getClass().getResource("cenas/Toolbar.fxml"));
			
			// Carregar e fazer uma lista com todas as outras telas.
			fxml = new ArrayList();
			fxml.add(FXMLLoader.load(getClass().getResource("cenas/Principal.fxml")));
			fxml.add(FXMLLoader.load(getClass().getResource("cenas/Funcionario.fxml")));
			
			// Mandar pra classe gerenciadora fazer o resto.
			GerenciadorCenas.inicializar(janela, root, fxml);
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
