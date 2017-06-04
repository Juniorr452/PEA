package application.controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.GerenciadorCenas;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ControladorCarrinho extends Controlador implements Initializable
{
	@FXML private Button continuarComprando;
	@FXML private Button finalizarCompra;
	@FXML private Label totalPreco;
	@FXML private VBox secao;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		totalPreco.setText(Double.toString(carrinho.calcularValorTotal()));
		
		ItemCarrinho item;
		
		// Vai adicionar cada produto da nossa lista
		// em sua respectiva se��o.
		for (ItemCarrinho p : carrinho.getProdutos())	
			secao.getChildren().add(p);
	}
	
	@FXML
	private void continuarComprando() throws IOException
	{
		GerenciadorCenas.irPara(1);
	}
	
	@FXML
	private void comprar() throws IOException 
	{
		System.out.println("Comprar");
	}
}
