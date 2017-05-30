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

public class ControladorCarrinho extends Controlador implements Initializable{
	
	@FXML private Button continuarComprando;
	@FXML private Button finalizarCompra;
	@FXML private Label totalPreco;
	@FXML private VBox secao;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		totalPreco.setText(Double.toString(calcularTotal()));
		
		ItemCarrinho item;
		
		// Vai adicionar cada produto da nossa lista
		// em sua respectiva se��o.
		for (ItemCarrinho p : produtosCarrinho)
		{
			//item = new ItemCarrinho();
		
			secao.getChildren().add(p);
		}
	}
	
	@FXML
	void comprar() throws IOException {
		GerenciadorCenas.irPara(1);
	}
	
	
	private double calcularTotal() {
		
		Double total = new Double(0);
		
		
		//double total = 0;
		
		//percorre a lista do carrinho, pegando item por item
		//e calculando o total do valor do carrinho
		for (ItemCarrinho p : produtosCarrinho) {
			total += p.getPreco() * p.getQtd();
		}
		
		//somando alguns precos, a parte decimal estava ficando gigante
		//portando usamos esse retorno para truncarmos em 2 casas decimais.
		return Math.floor(total * 100) / 100;
	}
	
	
}
