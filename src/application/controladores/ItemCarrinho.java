package application.controladores;

import java.io.IOException;

import application.Janelas;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import sistema_loja.interfaces.Produto;

public class ItemCarrinho extends HBox {
	
	@FXML private Label titulo;
	@FXML private TextField qtd;
	@FXML private Label preco;
	@FXML private Button remover;
	private Produto produto;
	
	public ItemCarrinho(Produto p)
	{
		// Preparar o FxmlLoader para carregar
		// o arquivo posteriormente.
		FXMLLoader fxmlLoader = new FXMLLoader(
	                getClass().getResource("../cenas/ItemCarrinho.fxml"));

		// Setar a raiz e controlador do .fxml a ser carregado
		// como essa inst�ncia.
	    fxmlLoader.setRoot(this);
	    fxmlLoader.setController(this);

	    try 
	    {
	    	// Carregar o arquivo.
	    	fxmlLoader.load();
	    } 
	    catch (IOException exception) 
	    {
	    	throw new RuntimeException(exception);
	    }
		
	    produto = p;
		titulo.setText(p.getTitulo());
		qtd.setText(Integer.toString(p.getQuantidadeDesejada()));
		preco.setText(Double.toString(p.getPreco()));
	}
	
	@FXML
	void remover() {
		Janelas.mensagem("teste", "removendo produto", AlertType.INFORMATION);
	}
}
