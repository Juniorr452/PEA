package application.controladores;

import java.io.IOException;

import application.GerenciadorCenas;
import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import sistema_loja.interfaces.Produto;

/**
 * Classe de uma VBox customizada.
 * <p>
 * Dentro dela, temos um ImageView e
 * duas Labels. Ao criar uma inst�ncia
 * dessa classe em qualquer outro lugar,
 * é possível colocá-la dentro de um outro .fxml.
 * 
 * Mais informa��es sobre criar elementos customizados em:
 * http://docs.oracle.com/javafx/2/fxml_get_started/custom_control.htm
 * 
 * @author Ênio José
 */
public class Item extends VBox
{
	@FXML private ImageView capa;
	@FXML private Label titulo;
	@FXML private Label autor;
	private Produto produto;
	
	public Item(Produto p)
	{
		// Preparar o FxmlLoader para carregar
		// o arquivo posteriormente.
		FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("cenas/Item.fxml"));
		
		// Setar a raiz e controlador do .fxml a ser carregado
		// como essa instância.
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
		
	    this.produto = p;
		this.titulo.setText(p.getTitulo());
		this.autor.setText(p.getAutor());
		capa.setImage(p.getImage());
	}
	
	@FXML 
	private void click() throws IOException
	{
		Controlador.produtoSelecionado = this.produto;
		GerenciadorCenas.irPara(3);
	}
}
