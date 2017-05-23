package application.controladores;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class ControladorProduto extends Controlador implements Initializable
{
	@FXML private Button adicionarCarrinho;
	@FXML private Label tituloItem;
	@FXML private ImageView capaItem;
	@FXML private Label autorItem;
	@FXML private Label precoItem;
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		tituloItem.setText(produtoSelecionado.getTitulo());
		capaItem.setImage(produtoSelecionado.getImage());
		autorItem.setText(produtoSelecionado.getAutor());
		precoItem.setText(Double.toString(produtoSelecionado.getPreco()));
	}
	
	@FXML
	void adicionarCarrinho() 
	{
		System.out.println("Adicionando no carrinho");
	}
	
	@FXML
	void comprar()
	{
		System.out.println("Comprando " + produtoSelecionado.getTitulo() +
				             " por R$ " + produtoSelecionado.getPreco());
	}
}
