package application.controladores;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.GerenciadorCenas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class ControladorVenda extends Controlador implements Initializable 
{
	private List<ItemCarrinho> produtosCarrinho;
	private double total;
	
	@FXML private ComboBox<String> formaPagamento;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		this.produtosCarrinho = Controlador.produtosCarrinho;
		total = ControladorCarrinho.calcularTotal();
		ObservableList<String> items = FXCollections.observableArrayList();

		items.addAll("Boleto Bancário... R$" + Double.toString(total),
					"Cartão de Crédito... 1 x R$" + Double.toString(total),
					"Cartão de Crédito... 2 x R$" + Double.toString(Math.floor(total/2 * 100) / 100),
					"Paypal... R$" + Double.toString(total));
		formaPagamento.setItems(items);
	}
	
	@FXML
	private void concluir()
	{
		try
		{
			// Verificar campos
			// Adicionar a venda na lista
			// Resetar o carrinho e ir pra tela principal
			GerenciadorCenas.irPara(PRINCIPAL);
		}
		catch(Exception e)
		{
			
		}
	}
	
	@FXML
	private void cancelar() throws IOException
	{
		GerenciadorCenas.irPara(PRINCIPAL);
	}
}
